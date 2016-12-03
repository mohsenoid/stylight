package com.stylight.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stylight.api.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class ProductsResponse {

    @SerializedName("start")
    @Expose
    private int start;
    @SerializedName("count")
    @Expose
    private int count;
    @SerializedName("totalResults")
    @Expose
    private int totalResults;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("products")
    @Expose
    private List<Product> products = new ArrayList<Product>();

    public ProductsResponse() {
    }


    public ProductsResponse(int start, int count, int totalResults, String next, List<Product> products) {
        this.start = start;
        this.count = count;
        this.totalResults = totalResults;
        this.next = next;
        this.products = products;
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

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
