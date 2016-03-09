package com.myapp.duytran.myapplication;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class YouTubeThumbnailsObject {
    private ThumbnailsDefaultObj defaultObj;
    private ThumbnailsMediumObj mediumObj;
    private ThumbnailsHighObj highObj;
    private String channelTitle;
    private String liveBroadcastContent;

    public ThumbnailsDefaultObj getDefaultObj() {
        return defaultObj;
    }

    public void setDefaultObj(ThumbnailsDefaultObj defaultObj) {
        this.defaultObj = defaultObj;
    }

    public ThumbnailsMediumObj getMediumObj() {
        return mediumObj;
    }

    public void setMediumObj(ThumbnailsMediumObj mediumObj) {
        this.mediumObj = mediumObj;
    }

    public ThumbnailsHighObj getHighObj() {
        return highObj;
    }

    public void setHighObj(ThumbnailsHighObj highObj) {
        this.highObj = highObj;
    }

    public String getChannelTitle() {
        return channelTitle;
    }

    public void setChannelTitle(String channelTitle) {
        this.channelTitle = channelTitle;
    }

    public String getLiveBroadcastContent() {
        return liveBroadcastContent;
    }

    public void setLiveBroadcastContent(String liveBroadcastContent) {
        this.liveBroadcastContent = liveBroadcastContent;
    }
}
