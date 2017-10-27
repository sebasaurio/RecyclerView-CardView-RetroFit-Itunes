package app.desarrollo.ituneszenteno;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import app.desarrollo.ituneszenteno.Adapters.AdapterContenido;
import app.desarrollo.ituneszenteno.Adapters.ApiAdapter;
import app.desarrollo.ituneszenteno.DB.Model;
import app.desarrollo.ituneszenteno.Entities.Contenido;
import app.desarrollo.ituneszenteno.Entities.Results;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView recyclerContenido;
    EditText txtBusqueda,txtLimit;
    ImageButton imgBtunBuscar;
    AdapterContenido adapterContenido;
    private ProgressDialog progressDialog;
    Spinner spBusqueda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressDialog= new ProgressDialog(this);
        recyclerContenido = (RecyclerView) findViewById(R.id.recyclerContenido);
        txtBusqueda = (EditText) findViewById(R.id.txtBusqueda);
        txtLimit = (EditText)findViewById(R.id.txtLimit);
        imgBtunBuscar = (ImageButton)findViewById(R.id.imgBtunBuscar);
        spBusqueda = (Spinner) findViewById(R.id.spBusqueda);
        imgBtunBuscar.setOnClickListener(this);


        ArrayList<String> listaBusqueda = new ArrayList<>();
        listaBusqueda.add("Artista");
        listaBusqueda.add("Musica");
        spBusqueda.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,listaBusqueda));

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imgBtunBuscar:
                int aux = 0;
                if(txtBusqueda.getText().toString().length()==0){
                    txtBusqueda.setError("Campo requerido!");aux+=1;
                }
                if(txtLimit.getText().toString().length()==0){
                    txtBusqueda.setError("Campo requerido!");aux+=1;
                }
                if(aux==0){
                    cargarDatos();
                }else{
                    Toast.makeText(getApplicationContext(), "Debes completar los campos de busqueda", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void cargarDatos(){
        progressDialog.setMessage("Buscando...");
        progressDialog.show();
        String busqueda = txtBusqueda.getText().toString().trim();
        int limite = 50;
        if(txtLimit.getText().toString().length()>0){
            limite = Integer.parseInt(txtLimit.getText().toString().trim());
        }

        String tipoBusqueda = "musicArtist";
        if(spBusqueda.getSelectedItemPosition()==1){
            tipoBusqueda = "musicTrack";
        }

        Call<Results> call = ApiAdapter.getApiService().getDataITunes(busqueda, "music",limite,tipoBusqueda);
        call.enqueue(new ListaContenidoCallback());

    }

    class ListaContenidoCallback implements Callback<Results>{
        @Override
        public void onResponse(Call<Results> call, Response<Results> response) {
            if(response.isSuccessful()){
                Results resultado = response.body();
                List<Contenido> listContenido = resultado.getResults();

                String tipoBusqueda = "artista";
                if(spBusqueda.getSelectedItemPosition()==1){
                    tipoBusqueda = "canciones";
                }
                adapterContenido = new AdapterContenido(listContenido, tipoBusqueda, getApplicationContext());
                recyclerContenido.setAdapter(adapterContenido);

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                recyclerContenido.setLayoutManager(mLayoutManager);
                recyclerContenido.setItemAnimator(new DefaultItemAnimator());
                Model model = new Model();
                if(Objects.equals(tipoBusqueda, "artista")){
                    for(int i = 0;i<listContenido.size();i++){

                        try {
                            model.guardarBusqueda(getApplicationContext(),listContenido.get(i));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }else if(Objects.equals(tipoBusqueda, "canciones")){
                    for(int i = 0;i<listContenido.size();i++){
                        model.guardarCancion(getApplicationContext(),listContenido.get(i));
                    }
                }
                progressDialog.dismiss();
            }
        }

        @Override
        public void onFailure(Call<Results> call, Throwable t) {
            Toast.makeText(getApplicationContext(), "ERROR"+t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
