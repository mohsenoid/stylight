package com.stylight.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class SearchRequestParameters {

    @SerializedName("categories")
    @Expose
    private List<ProductCategory> categories = new ArrayList<>();
    @SerializedName("colors")
    @Expose
    private List<Object> colors = new ArrayList<>();
    @SerializedName("styles")
    @Expose
    private List<Object> styles = new ArrayList<>();
    @SerializedName("patterns")
    @Expose
    private List<Object> patterns = new ArrayList<>();
    @SerializedName("brands")
    @Expose
    private List<Object> brands = new ArrayList<>();
    @SerializedName("shops")
    @Expose
    private List<Object> shops = new ArrayList<>();
    @SerializedName("materials")
    @Expose
    private List<Object> materials = new ArrayList<>();
    @SerializedName("occasions")
    @Expose
    private List<Object> occasions = new ArrayList<>();
    @SerializedName("rooms")
    @Expose
    private List<Object> rooms = new ArrayList<>();
    @SerializedName("minPrice")
    @Expose
    private Object minPrice;
    @SerializedName("maxPrice")
    @Expose
    private Object maxPrice;
    @SerializedName("sale")
    @Expose
    private boolean sale;
    @SerializedName("freeShipping")
    @Expose
    private boolean freeShipping;
    @SerializedName("searchString")
    @Expose
    private Object searchString;
    @SerializedName("sortBy")
    @Expose
    private String sortBy;
    @SerializedName("gender")
    @Expose
    private Object gender;
    @SerializedName("verticals")
    @Expose
    private List<String> verticals = new ArrayList<String>();

    /**
     * No args constructor for use in serialization
     */
    public SearchRequestParameters() {
    }

    /**
     * @param patterns
     * @param searchString
     * @param freeShipping
     * @param colors
     * @param styles
     * @param maxPrice
     * @param verticals
     * @param sale
     * @param brands
     * @param sortBy
     * @param materials
     * @param shops
     * @param gender
     * @param categories
     * @param occasions
     * @param rooms
     * @param minPrice
     */
    public SearchRequestParameters(List<ProductCategory> categories, List<Object> colors, List<Object> styles, List<Object> patterns, List<Object> brands, List<Object> shops, List<Object> materials, List<Object> occasions, List<Object> rooms, Object minPrice, Object maxPrice, boolean sale, boolean freeShipping, Object searchString, String sortBy, Object gender, List<String> verticals) {
        this.categories = categories;
        this.colors = colors;
        this.styles = styles;
        this.patterns = patterns;
        this.brands = brands;
        this.shops = shops;
        this.materials = materials;
        this.occasions = occasions;
        this.rooms = rooms;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.sale = sale;
        this.freeShipping = freeShipping;
        this.searchString = searchString;
        this.sortBy = sortBy;
        this.gender = gender;
        this.verticals = verticals;
    }

    /**
     * @return The categories
     */
    public List<ProductCategory> getCategories() {
        return categories;
    }

    /**
     * @param categories The categories
     */
    public void setCategories(List<ProductCategory> categories) {
        this.categories = categories;
    }

    /**
     * @return The colors
     */
    public List<Object> getColors() {
        return colors;
    }

    /**
     * @param colors The colors
     */
    public void setColors(List<Object> colors) {
        this.colors = colors;
    }

    /**
     * @return The styles
     */
    public List<Object> getStyles() {
        return styles;
    }

    /**
     * @param styles The styles
     */
    public void setStyles(List<Object> styles) {
        this.styles = styles;
    }

    /**
     * @return The patterns
     */
    public List<Object> getPatterns() {
        return patterns;
    }

    /**
     * @param patterns The patterns
     */
    public void setPatterns(List<Object> patterns) {
        this.patterns = patterns;
    }

    /**
     * @return The brands
     */
    public List<Object> getBrands() {
        return brands;
    }

    /**
     * @param brands The brands
     */
    public void setBrands(List<Object> brands) {
        this.brands = brands;
    }

    /**
     * @return The shops
     */
    public List<Object> getShops() {
        return shops;
    }

    /**
     * @param shops The shops
     */
    public void setShops(List<Object> shops) {
        this.shops = shops;
    }

    /**
     * @return The materials
     */
    public List<Object> getMaterials() {
        return materials;
    }

    /**
     * @param materials The materials
     */
    public void setMaterials(List<Object> materials) {
        this.materials = materials;
    }

    /**
     * @return The occasions
     */
    public List<Object> getOccasions() {
        return occasions;
    }

    /**
     * @param occasions The occasions
     */
    public void setOccasions(List<Object> occasions) {
        this.occasions = occasions;
    }

    /**
     * @return The rooms
     */
    public List<Object> getRooms() {
        return rooms;
    }

    /**
     * @param rooms The rooms
     */
    public void setRooms(List<Object> rooms) {
        this.rooms = rooms;
    }

    /**
     * @return The minPrice
     */
    public Object getMinPrice() {
        return minPrice;
    }

    /**
     * @param minPrice The minPrice
     */
    public void setMinPrice(Object minPrice) {
        this.minPrice = minPrice;
    }

    /**
     * @return The maxPrice
     */
    public Object getMaxPrice() {
        return maxPrice;
    }

    /**
     * @param maxPrice The maxPrice
     */
    public void setMaxPrice(Object maxPrice) {
        this.maxPrice = maxPrice;
    }

    /**
     * @return The sale
     */
    public boolean isSale() {
        return sale;
    }

    /**
     * @param sale The sale
     */
    public void setSale(boolean sale) {
        this.sale = sale;
    }

    /**
     * @return The freeShipping
     */
    public boolean isFreeShipping() {
        return freeShipping;
    }

    /**
     * @param freeShipping The freeShipping
     */
    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    /**
     * @return The searchString
     */
    public Object getSearchString() {
        return searchString;
    }

    /**
     * @param searchString The searchString
     */
    public void setSearchString(Object searchString) {
        this.searchString = searchString;
    }

    /**
     * @return The sortBy
     */
    public String getSortBy() {
        return sortBy;
    }

    /**
     * @param sortBy The sortBy
     */
    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    /**
     * @return The gender
     */
    public Object getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(Object gender) {
        this.gender = gender;
    }

    /**
     * @return The verticals
     */
    public List<String> getVerticals() {
        return verticals;
    }

    /**
     * @param verticals The verticals
     */
    public void setVerticals(List<String> verticals) {
        this.verticals = verticals;
    }

}
