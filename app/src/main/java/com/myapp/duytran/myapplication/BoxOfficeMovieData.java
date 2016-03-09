package com.myapp.duytran.myapplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoxOfficeMovieData {
    //private BoxOfficeMovieDates dates;
    private int page;
    private List<BoxOfficeMovie> results;
    private int total_pages;
    private int total_results;

//    public BoxOfficeMovieDates getDates() {
//        return dates;
//    }
//
//    public void setDates(BoxOfficeMovieDates dates) {
//        this.dates = dates;
//    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<BoxOfficeMovie> getResults() {
        return results;
    }

    public void setResults(List<BoxOfficeMovie> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getTotal_results() {
        return total_results;
    }

    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }
}
