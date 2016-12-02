package com.stylight.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class Image {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("primary")
    @Expose
    private boolean primary;
    @SerializedName("alt")
    @Expose
    private String alt;
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("source")
    @Expose
    private String source;

    public Image() {
    }

    public Image(String url, boolean primary, String alt, String caption, String source) {
        this.url = url;
        this.primary = primary;
        this.alt = alt;
        this.caption = caption;
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
