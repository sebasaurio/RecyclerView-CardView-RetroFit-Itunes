package app.desarrollo.ituneszenteno.Calls;


import java.util.List;

import app.desarrollo.ituneszenteno.Entities.Results;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface EndPoints {

    //?term={term}&media={media}&limit={limit}
    @GET("search")
    Call<Results> getDataITunes(@Query("term")String term,
                                @Query("media")String media,
                                @Query("limit") int limit,
                                @Query("entity") String entity);

}
