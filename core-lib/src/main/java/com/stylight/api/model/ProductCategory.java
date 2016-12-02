package com.stylight.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class ProductCategory {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("relevance")
    @Expose
    private int relevance;
    @SerializedName("children")
    @Expose
    private List<Object> children = new ArrayList<Object>();

    /**
     * No args constructor for use in serialization
     */
    public ProductCategory() {
    }

    /**
     * @param id
     * @param name
     * @param relevance
     * @param children
     */
    public ProductCategory(int id, String name, int relevance, List<Object> children) {
        this.id = id;
        this.name = name;
        this.relevance = relevance;
        this.children = children;
    }

    /**
     * @return The id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The relevance
     */
    public int getRelevance() {
        return relevance;
    }

    /**
     * @param relevance The relevance
     */
    public void setRelevance(int relevance) {
        this.relevance = relevance;
    }

    /**
     * @return The children
     */
    public List<Object> getChildren() {
        return children;
    }

    /**
     * @param children The children
     */
    public void setChildren(List<Object> children) {
        this.children = children;
    }

}
