package app.desarrollo.ituneszenteno.Adapters;


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import app.desarrollo.ituneszenteno.DB.Model;
import app.desarrollo.ituneszenteno.Entities.Contenido;
import app.desarrollo.ituneszenteno.R;

public class AdapterContenido extends RecyclerView.Adapter<AdapterContenido.MyHolder>{

    List<Contenido> listaContenido;
    String tipoBusqueda;
    Context context;

    public AdapterContenido(List<Contenido> lista, String tipoBusqueda, Context context){
        this.listaContenido = lista;
        this.tipoBusqueda = tipoBusqueda;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_view_contenido, parent, false);

        return new MyHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        try {
            Model model = new Model();
            Contenido contenido = listaContenido.get(position);

            if(tipoBusqueda == "canciones"){
                holder.txtTitulo.setText(contenido.getArtistName());
                holder.txtAlbum.setText(contenido.getCollectionName()+" \n Track: "+contenido.getTrackName());
                holder.txtCantBusquedas.setVisibility(View.GONE);
                holder.txtCantCanciones.setText("Canciones: "+String.valueOf(contenido.getTrackCount()));
                final String finalImgURL = listaContenido.get(position).getArtworkUrl100();
                ImageLoader.getInstance().displayImage(finalImgURL, holder.imgContenido);

                if(contenido.getReleaseDate()==null){
                    holder.txtFechaLanzamiento.setText("");
                }else{
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
                    Date fechaLanzamiento = format.parse(contenido.getReleaseDate());
                    holder.txtFechaLanzamiento.setText("Lanzamiento: "+DateFormat.format("dd-MM-yyyy", fechaLanzamiento));
                }
            }
            else if(tipoBusqueda == "artista"){
                holder.txtTitulo.setText(contenido.getArtistName());
                holder.txtAlbum.setVisibility(View.GONE);
                holder.txtCantCanciones.setVisibility(View.GONE);
                holder.txtFechaLanzamiento.setVisibility(View.GONE);
                holder.imgContenido.setVisibility(View.GONE);
                holder.txtCantBusquedas.setText("Busquedas: "+String.valueOf(model.selectCantidadBusquedas(context,contenido)));


            }


        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return listaContenido.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        CardView cardViewContenido;
        TextView txtTitulo, txtAlbum, txtFechaLanzamiento, txtCantCanciones, txtCantBusquedas;
        ImageView imgContenido;
        public MyHolder(View view){
            super(view);
            cardViewContenido = (CardView)view.findViewById(R.id.cardViewContenido);
            txtTitulo = (TextView)view.findViewById(R.id.txtTitulo);
            txtAlbum = (TextView)view.findViewById(R.id.txtAlbum);
            txtFechaLanzamiento = (TextView)view.findViewById(R.id.txtFechaLanzamiento);
            txtCantCanciones = (TextView)view.findViewById(R.id.txtCantCanciones);
            txtCantBusquedas = (TextView)view.findViewById(R.id.txtCantBusquedas);
            imgContenido = (ImageView)view.findViewById(R.id.imgContenido);
        }
    }
}
