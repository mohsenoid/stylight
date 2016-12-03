package com.stylight.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class Product {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("currency")
    @Expose
    private Currency currency;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<>();

    public Product() {
    }

    public Product(int id, String name, double price, Currency currency, String url, List<Image> images) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.currency = currency;
        this.url = url;
        this.images = images;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

}
