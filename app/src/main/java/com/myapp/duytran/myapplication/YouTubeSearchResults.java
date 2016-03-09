package com.myapp.duytran.myapplication;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YouTubeSearchResults {
    private String kind;
    private String etag;
    private String nextPageToken;
    private String regionCode;
    private PageInfoObject pageInfo;
    private List<YouTubeSearchResource> items;

    public PageInfoObject getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoObject pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getNextPageToken() {
        return nextPageToken;
    }

    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
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

    public List<YouTubeSearchResource> getItems() {
        return items;
    }

    public void setItems(List<YouTubeSearchResource> items) {
        this.items = items;
    }


}
