package app.desarrollo.ituneszenteno.DB;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import app.desarrollo.ituneszenteno.Entities.Contenido;

public class Model {

    private final String NOMBRE_DB = "ITUNES";
    public Model(){

    }

    public void guardarBusqueda(Context context, Contenido contenido) throws ParseException {
        Conexion con = new Conexion(context,NOMBRE_DB,null,1);
        SQLiteDatabase db = con.getWritableDatabase();


        if(existeArtista(context,contenido)>0){
            //EXISTE EL ARTISTA EN LA BD
            int cantBusquedas = selectCantidadBusquedas(context, contenido)+1;
            actualizarCantidadBusquedas(context,contenido,cantBusquedas);
        }else{
            //NO EXISTE EN LA BD
            ContentValues contentValues = new ContentValues();
            contentValues.put("artista",contenido.getArtistName());
            contentValues.put("cant_busquedas",0);
            db.insert("contenido",null,contentValues);
        }
    }

    public int existeArtista(Context context, Contenido contenido){
        Conexion con = new Conexion(context,NOMBRE_DB,null,1);
        SQLiteDatabase db = con.getReadableDatabase();
        String[] parametros = {contenido.getArtistName()};

        Cursor cursor = db.rawQuery("select count(1) from contenido where artista=?",parametros);
        if(cursor.getColumnCount()>0){
            cursor.moveToFirst();
            return cursor.getInt(0);
        }
        return 0;
    }

    public int selectCantidadBusquedas(Context context, Contenido contenido){
        try{
            Conexion con = new Conexion(context,NOMBRE_DB,null,1);
            SQLiteDatabase db = con.getReadableDatabase();
            String[] parametros = {contenido.getArtistName()};

            Cursor cursor = db.rawQuery("select cant_busquedas from contenido where artista=?",parametros);
            if(cursor.getColumnCount()>0){
                cursor.moveToFirst();
                return cursor.getInt(0);
            }
            return 0;
        }catch (Exception e){
            Log.e("error consulta",e.getMessage());
            return 0;
        }
    }

    public boolean actualizarCantidadBusquedas(Context context, Contenido contenido,int cantBusquedas){
        Conexion con = new Conexion(context,NOMBRE_DB,null,1);
        SQLiteDatabase db = con.getWritableDatabase();
        String[] parametros = {contenido.getArtistName()};

        ContentValues contentValues = new ContentValues();
        contentValues.put("cant_busquedas",cantBusquedas);

        long i = db.update("contenido",contentValues,"artista=?",parametros);
        return i>0;
    }

    public boolean guardarCancion(Context context, Contenido contenido){
        Conexion con = new Conexion(context,NOMBRE_DB,null,1);
        SQLiteDatabase db = con.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("artista",contenido.getArtistName());
        contentValues.put("tema",contenido.getTrackName());
        contentValues.put("album",contenido.getTrackName());
        contentValues.put("fecha_lanzamiento",contenido.getReleaseDate());
        contentValues.put("cant_canciones",contenido.getTrackCount());
        long i = db.insert("contenido",null,contentValues);
        return (i>0);
    }

}
