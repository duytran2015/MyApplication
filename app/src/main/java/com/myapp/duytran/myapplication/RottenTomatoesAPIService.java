package com.myapp.duytran.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface RottenTomatoesAPIService {

    @GET("movie/now_playing")
    Call<BoxOfficeMovieData> getRecentMovies(
            @Query("api_key") String api_key,
            @Query("format") String format
    );
}
