package app.desarrollo.ituneszenteno.Adapters;

import app.desarrollo.ituneszenteno.Calls.EndPoints;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiAdapter {

    private static EndPoints API_SERVICE; //Clase interfaz de los metodos


    public static EndPoints getApiService(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpclient = new OkHttpClient.Builder();
        httpclient.addInterceptor(interceptor);

        String baseURL = "https://itunes.apple.com/";
        if(API_SERVICE==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(baseURL)
                    .client(httpclient.build())
                    .addConverterFactory(GsonConverterFactory.create()).build();
                API_SERVICE = retrofit.create(EndPoints.class);
        }
        return API_SERVICE;
    }
}
