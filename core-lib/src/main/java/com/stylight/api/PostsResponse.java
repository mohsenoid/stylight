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

    /**
     * No args constructor for use in serialization
     */
    public PostsResponse() {
    }

    /**
     * @param count
     * @param totalCount
     * @param start
     * @param next
     * @param posts
     * @param featuredPosts
     */
    public PostsResponse(List<Post> posts, List<Post> featuredPosts, int start, int count, int totalCount, String next) {
        this.posts = posts;
        this.featuredPosts = featuredPosts;
        this.start = start;
        this.count = count;
        this.totalCount = totalCount;
        this.next = next;
    }

    /**
     * @return The posts
     */
    public List<Post> getPosts() {
        return posts;
    }

    /**
     * @param posts The posts
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * @return The featuredPosts
     */
    public List<Post> getFeaturedPosts() {
        return featuredPosts;
    }

    /**
     * @param featuredPosts The featuredPosts
     */
    public void setFeaturedPosts(List<Post> featuredPosts) {
        this.featuredPosts = featuredPosts;
    }

    /**
     * @return The start
     */
    public int getStart() {
        return start;
    }

    /**
     * @param start The start
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * @return The count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return The totalCount
     */
    public int getTotalCount() {
        return totalCount;
    }

    /**
     * @param totalCount The totalCount
     */
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    /**
     * @return The next
     */
    public String getNext() {
        return next;
    }

    /**
     * @param next The next
     */
    public void setNext(String next) {
        this.next = next;
    }

}
