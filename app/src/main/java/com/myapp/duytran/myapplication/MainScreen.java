package com.myapp.duytran.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ListView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.JacksonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainScreen extends AppCompatActivity {

    private int totalPages;
    private int currentPage;
    private ListView movieListView;
    private BoxOfficeMovieAdapter movieAdapter;
    private TheMovieDBService service;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainscreen);

        movieListView = (ListView) findViewById(R.id.movieListView);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://api.themoviedb.org/3/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

        service = retrofit.create(TheMovieDBService.class);
        currentPage = 1;
        final Call<BoxOfficeMovieData> movieDataCall = service.discoverMovies(
                "6add24f9668b216fadcddfa7da9710f0",
                currentPage,
                "US",
                "NC-17",
                "release_date.desc",
                "2016-03-01",
                "2017-12-31"
        );

        movieDataCall.enqueue(new Callback<BoxOfficeMovieData>() {
            @Override
            public void onResponse(Response<BoxOfficeMovieData> response) {
                totalPages = response.body().getTotal_pages();
                Log.i("TEST", "Number of pages: " + totalPages);
                Log.i("TEST", "Current page: " + currentPage);
                movieAdapter = new BoxOfficeMovieAdapter(
                        MainScreen.this,
                        R.layout.activity_mainscreen_item,
                        response.body().getResults()
                );
                movieListView.setAdapter(movieAdapter);
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("TEST", "Failed to get the result.", t);
            }
        });

        movieListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            int scrollState;

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                this.scrollState = scrollState;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if (((firstVisibleItem + visibleItemCount) == totalItemCount) && (scrollState == SCROLL_STATE_IDLE)
                        && (currentPage <= totalPages)) {
                    currentPage++;
                    final Call<BoxOfficeMovieData> movieDataCall = service.discoverMovies(
                            "6add24f9668b216fadcddfa7da9710f0",
                            currentPage,
                            "US",
                            "NC-17",
                            "release_date.desc",
                            "2016-03-01",
                            "2017-12-31"
                    );

                    movieDataCall.enqueue(new Callback<BoxOfficeMovieData>() {
                        @Override
                        public void onResponse(Response<BoxOfficeMovieData> response) {
                            Log.i("TEST", "Current page: " + currentPage);
                            movieAdapter = new BoxOfficeMovieAdapter(
                                    MainScreen.this,
                                    R.layout.activity_mainscreen_item,
                                    response.body().getResults()
                            );
                            movieListView.setAdapter(movieAdapter);
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            Log.e("TEST", "Failed to get the result.", t);
                        }
                    });
                }
            }
        });

    }

}
