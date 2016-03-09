package com.myapp.duytran.myapplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoxOfficeMovie {
    private String title;
    private String release_date;
    private String poster_path;
    private int vote_average;

    public String getTitle() { return title; }

    public String getRelease_date() { return release_date; }

    public String getPoster_path() { return poster_path; }


    public int getVote_average() {return vote_average;}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }


    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }
}
