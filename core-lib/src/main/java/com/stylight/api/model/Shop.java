package com.stylight.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class Shop {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("premium")
    @Expose
    private boolean premium;
    @SerializedName("site")
    @Expose
    private Site site;
    @SerializedName("logo")
    @Expose
    private String logo;

    /**
     * No args constructor for use in serialization
     */
    public Shop() {
    }

    /**
     * @param site
     * @param id
     * @param logo
     * @param premium
     * @param name
     */
    public Shop(int id, String name, boolean premium, Site site, String logo) {
        this.id = id;
        this.name = name;
        this.premium = premium;
        this.site = site;
        this.logo = logo;
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
     * @return The premium
     */
    public boolean isPremium() {
        return premium;
    }

    /**
     * @param premium The premium
     */
    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    /**
     * @return The site
     */
    public Site getSite() {
        return site;
    }

    /**
     * @param site The site
     */
    public void setSite(Site site) {
        this.site = site;
    }

    /**
     * @return The logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     * @param logo The logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

}
