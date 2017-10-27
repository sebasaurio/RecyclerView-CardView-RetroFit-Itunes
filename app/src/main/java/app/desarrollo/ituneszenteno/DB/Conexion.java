package app.desarrollo.ituneszenteno.DB;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexion extends SQLiteOpenHelper{

    private  String TABLA_CONTENIDO = "create table contenido(id int auto_increment primary key, " +
            "artista text," +
            "tema text," +
            "album text," +
            "fecha_lanzamiento date," +
            "cant_canciones int," +
            "cant_busquedas)";

    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_CONTENIDO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exist contenido");
        onCreate(db);
    }
}
