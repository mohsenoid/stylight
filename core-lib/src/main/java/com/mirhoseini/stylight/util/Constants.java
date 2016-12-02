package com.mirhoseini.stylight.util;

/**
 * Created by Mohsen on 02/12/2016.
 */

public abstract class Constants {

    public static final String BASE_URL = " https://api.stylight.com/rest/";

    public static final int CLOTHING_PRODUCTS_CATEGORY_ID = 10203;
    public static final int LAMPS_PRODUCTS_CATEGORY_ID = 28107;

    public static final String FASHION_POSTS_CATEGORY_SLUG_CLOTHING = "fashion";
    public static final String LIFESTYLE_POSTS_CATEGORY_SLUG_CLOTHING = "lifestyle";

    public static final int NETWORK_CONNECTION_TIMEOUT = 30; // 30 sec
    public static final long CACHE_SIZE = 10 * 1024 * 1024; // 10 MB
    public static final int CACHE_MAX_AGE = 2; // 2 min
    public static final int CACHE_MAX_STALE = 7; // 7 day

}
