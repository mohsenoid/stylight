package com.stylight.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class Product {

    @SerializedName("available")
    @Expose
    private boolean available;
    @SerializedName("brand")
    @Expose
    private Brand brand;
    @SerializedName("shop")
    @Expose
    private Shop shop;
    @SerializedName("currency")
    @Expose
    private Currency currency;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("masterProductId")
    @Expose
    private int masterProductId;
    @SerializedName("hasUnits")
    @Expose
    private boolean hasUnits;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("shopLink")
    @Expose
    private String shopLink;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("price")
    @Expose
    private double price;
    @SerializedName("savings")
    @Expose
    private double savings;
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<>();
    @SerializedName("sale")
    @Expose
    private boolean sale;
    @SerializedName("shippingCost")
    @Expose
    private double shippingCost;
    @SerializedName("checkoutId")
    @Expose
    private String checkoutId;
    @SerializedName("vertical")
    @Expose
    private String vertical;

    /**
     * No args constructor for use in serialization
     */
    public Product() {
    }

    /**
     * @param vertical
     * @param shop
     * @param desc
     * @param shippingCost
     * @param savings
     * @param available
     * @param masterProductId
     * @param shopLink
     * @param date
     * @param url
     * @param sale
     * @param currency
     * @param id
     * @param hasUnits
     * @param price
     * @param name
     * @param images
     * @param brand
     * @param gender
     * @param checkoutId
     */
    public Product(boolean available, Brand brand, Shop shop, Currency currency, String date, String desc, String gender, int id, int masterProductId, boolean hasUnits, String url, String shopLink, String name, double price, double savings, List<Image> images, boolean sale, int shippingCost, String checkoutId, String vertical) {
        this.available = available;
        this.brand = brand;
        this.shop = shop;
        this.currency = currency;
        this.date = date;
        this.desc = desc;
        this.gender = gender;
        this.id = id;
        this.masterProductId = masterProductId;
        this.hasUnits = hasUnits;
        this.url = url;
        this.shopLink = shopLink;
        this.name = name;
        this.price = price;
        this.savings = savings;
        this.images = images;
        this.sale = sale;
        this.shippingCost = shippingCost;
        this.checkoutId = checkoutId;
        this.vertical = vertical;
    }

    /**
     * @return The available
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * @param available The available
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * @return The brand
     */
    public Brand getBrand() {
        return brand;
    }

    /**
     * @param brand The brand
     */
    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    /**
     * @return The shop
     */
    public Shop getShop() {
        return shop;
    }

    /**
     * @param shop The shop
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    /**
     * @return The currency
     */
    public Currency getCurrency() {
        return currency;
    }

    /**
     * @param currency The currency
     */
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * @return The date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return The desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc The desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @return The gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender The gender
     */
    public void setGender(String gender) {
        this.gender = gender;
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
     * @return The masterProductId
     */
    public int getMasterProductId() {
        return masterProductId;
    }

    /**
     * @param masterProductId The masterProductId
     */
    public void setMasterProductId(int masterProductId) {
        this.masterProductId = masterProductId;
    }

    /**
     * @return The hasUnits
     */
    public boolean isHasUnits() {
        return hasUnits;
    }

    /**
     * @param hasUnits The hasUnits
     */
    public void setHasUnits(boolean hasUnits) {
        this.hasUnits = hasUnits;
    }

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return The shopLink
     */
    public String getShopLink() {
        return shopLink;
    }

    /**
     * @param shopLink The shopLink
     */
    public void setShopLink(String shopLink) {
        this.shopLink = shopLink;
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
     * @return The price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price The price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return The savings
     */
    public double getSavings() {
        return savings;
    }

    /**
     * @param savings The savings
     */
    public void setSavings(double savings) {
        this.savings = savings;
    }

    /**
     * @return The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * @param images The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
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
     * @return The shippingCost
     */
    public double getShippingCost() {
        return shippingCost;
    }

    /**
     * @param shippingCost The shippingCost
     */
    public void setShippingCost(double shippingCost) {
        this.shippingCost = shippingCost;
    }

    /**
     * @return The checkoutId
     */
    public String getCheckoutId() {
        return checkoutId;
    }

    /**
     * @param checkoutId The checkoutId
     */
    public void setCheckoutId(String checkoutId) {
        this.checkoutId = checkoutId;
    }

    /**
     * @return The vertical
     */
    public String getVertical() {
        return vertical;
    }

    /**
     * @param vertical The vertical
     */
    public void setVertical(String vertical) {
        this.vertical = vertical;
    }

}
