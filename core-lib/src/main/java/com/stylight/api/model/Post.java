package com.stylight.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class Post implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("teaserImage")
    @Expose
    private String teaserImage;


    public Post() {
    }

    public Post(int id, String title, String link, Category category, String teaserImage) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.category = category;
        this.teaserImage = teaserImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category postCategory) {
        this.category = postCategory;
    }

    public String getTeaserImage() {
        return teaserImage;
    }

    public void setTeaserImage(String teaserImage) {
        this.teaserImage = teaserImage;
    }
}
