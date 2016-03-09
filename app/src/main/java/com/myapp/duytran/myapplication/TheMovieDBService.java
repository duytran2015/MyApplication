package com.myapp.duytran.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TheMovieDBService {

    @GET("discover/movie")
    Call<BoxOfficeMovieData> discoverMovies(
            @Query("api_key") String api_key,
            @Query("page") int page,
            @Query("certification_country") String certification_counrty,
            @Query("certification.lte") String certification,
            @Query("sort_by") String sort_by,
            @Query("primary_release_date.gte") String begin,
            @Query("primary_release_date.lte") String end

    );

    @GET("movie/upcoming")
    Call<BoxOfficeMovieData> getUpComingMovies(
            @Query("api_key") String api_key,
            @Query("page") int page
    );


}
