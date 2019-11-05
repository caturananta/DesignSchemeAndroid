package co.id.dicoding.fragmentviewmodel.api;

import co.id.dicoding.fragmentviewmodel.rest.ListMovieResponse;
import co.id.dicoding.fragmentviewmodel.rest.ListTvShowResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PlaceholderAPI {

    @GET("movie")
    Call<ListMovieResponse> getMovies(@Query("api_key") String api, @Query("language") String lang);

    @GET("tv")
    Call<ListTvShowResponse> getTvShows(@Query("api_key") String api, @Query("language") String lang);
}
