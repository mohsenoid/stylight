package com.stylight.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.stylight.api.model.Product;
import com.stylight.api.model.SearchRequestParameters;

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
    @SerializedName("statistics")
    @Expose
    private Object statistics;
    @SerializedName("searchRequestParameters")
    @Expose
    private SearchRequestParameters searchRequestParameters;

    /**
     * No args constructor for use in serialization
     */
    public ProductsResponse() {
    }

    /**
     * @param count
     * @param totalResults
     * @param start
     * @param searchRequestParameters
     * @param next
     * @param products
     * @param statistics
     */
    public ProductsResponse(int start, int count, int totalResults, String next, List<Product> products, Object statistics, SearchRequestParameters searchRequestParameters) {
        this.start = start;
        this.count = count;
        this.totalResults = totalResults;
        this.next = next;
        this.products = products;
        this.statistics = statistics;
        this.searchRequestParameters = searchRequestParameters;
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
     * @return The totalResults
     */
    public int getTotalResults() {
        return totalResults;
    }

    /**
     * @param totalResults The totalResults
     */
    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
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

    /**
     * @return The products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * @param products The products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    /**
     * @return The statistics
     */
    public Object getStatistics() {
        return statistics;
    }

    /**
     * @param statistics The statistics
     */
    public void setStatistics(Object statistics) {
        this.statistics = statistics;
    }

    /**
     * @return The searchRequestParameters
     */
    public SearchRequestParameters getSearchRequestParameters() {
        return searchRequestParameters;
    }

    /**
     * @param searchRequestParameters The searchRequestParameters
     */
    public void setSearchRequestParameters(SearchRequestParameters searchRequestParameters) {
        this.searchRequestParameters = searchRequestParameters;
    }


}
