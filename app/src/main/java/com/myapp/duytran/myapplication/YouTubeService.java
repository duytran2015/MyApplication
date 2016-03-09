package com.myapp.duytran.myapplication;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface YouTubeService {

    @GET("search")
    Call<YouTubeSearchResults> getSearchResults(
            @Query("part") String part,
            @Query("maxResults") int maxResults,
            @Query("q") String q,
            @Query("key") String key
    );
}
