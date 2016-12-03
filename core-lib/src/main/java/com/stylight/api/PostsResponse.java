package com.stylight.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stylight.api.model.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class PostsResponse {

    @SerializedName("posts")
    @Expose
    private List<Post> posts = new ArrayList<>();
    @SerializedName("featuredPosts")
    @Expose
    private List<Post> featuredPosts = new ArrayList<>();
    @SerializedName("start")
    @Expose
    private int start;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("totalCount")
    @Expose
    private int totalCount;
    @SerializedName("next")
    @Expose
    private String next;

    public PostsResponse() {
    }

    public PostsResponse(List<Post> posts, List<Post> featuredPosts, int start, int count, int totalCount, String next) {
        this.posts = posts;
        this.featuredPosts = featuredPosts;
        this.start = start;
        this.count = count;
        this.totalCount = totalCount;
        this.next = next;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getFeaturedPosts() {
        return featuredPosts;
    }

    public void setFeaturedPosts(List<Post> featuredPosts) {
        this.featuredPosts = featuredPosts;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

}
