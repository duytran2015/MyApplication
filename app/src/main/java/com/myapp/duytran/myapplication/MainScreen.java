package com.myapp.duytran.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.JacksonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainScreen extends AppCompatActivity {

    private ListView movieListView;
    private BoxOfficeMovieAdapter movieAdapter;
    private RottenTomatoesAPIService service;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        movieListView = (ListView) findViewById(R.id.movieListView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        service = retrofit.create(RottenTomatoesAPIService.class);
        Call<BoxOfficeMovieData> movieDataCall = service.getRecentMovies(
                "6add24f9668b216fadcddfa7da9710f0",
                "json"
        );

        movieDataCall.enqueue(new Callback<BoxOfficeMovieData>() {
            @Override
            public void onResponse(Response<BoxOfficeMovieData> response) {
                movieAdapter =
                        new BoxOfficeMovieAdapter(
                                response.body().getMovies().getMovie(),MainScreen.this);
                movieListView.setAdapter(movieAdapter);

            }

            @Override
            public void onFailure(Throwable t) {

            }
        });

    }

}
