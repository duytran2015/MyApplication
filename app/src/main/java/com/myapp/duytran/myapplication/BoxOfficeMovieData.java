package com.myapp.duytran.myapplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoxOfficeMovieData {
    private BoxOfficeMoviesRecord movies;

    public BoxOfficeMoviesRecord getMovies() {
        return movies;
    }

    public void setMovies(BoxOfficeMoviesRecord movies) {
        this.movies = movies;
    }
}
