package com.stylight.api.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class Site {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("locale")
    @Expose
    private String locale;

    /**
     * No args constructor for use in serialization
     */
    public Site() {
    }

    /**
     * @param id
     * @param locale
     */
    public Site(int id, String locale) {
        this.id = id;
        this.locale = locale;
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
     * @return The locale
     */
    public String getLocale() {
        return locale;
    }

    /**
     * @param locale The locale
     */
    public void setLocale(String locale) {
        this.locale = locale;
    }

}
