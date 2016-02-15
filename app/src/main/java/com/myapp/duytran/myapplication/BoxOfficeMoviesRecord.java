package com.myapp.duytran.myapplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoxOfficeMoviesRecord {
    private List<BoxOfficeMovie> movie;

    public List<BoxOfficeMovie> getMovie() {
        return movie;
    }

    public void setMovie(List<BoxOfficeMovie> movie) {
        this.movie = movie;
    }
}
