package com.myapp.duytran.myapplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YouTubeSearchResource {
    private String kind;
    private String etag;
    private YouTubeIdObject id;
    private YouTubeSnippetObject snippet;


    public YouTubeIdObject getId() {
        return id;
    }

    public void setId(YouTubeIdObject id) {
        this.id = id;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public YouTubeSnippetObject getSnippet() {
        return snippet;
    }

    public void setSnippet(YouTubeSnippetObject snippet) {
        this.snippet = snippet;
    }
}
