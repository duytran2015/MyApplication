package com.myapp.duytran.myapplication;

import android.text.TextUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BoxOfficeMovie {
    private String title;
    private String release_date;
    private String poster_path;
    private String status;
    private int vote_average;
    //private ArrayList<String> genres;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getVote_average() {
        return vote_average;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }
    /*
    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }
    */
}
