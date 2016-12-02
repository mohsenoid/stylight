package com.mirhoseini.stylight.domain.client;


import com.stylight.api.PostsResponse;
import com.stylight.api.ProductsResponse;

import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Mohsen on 02/12/2016.
 */

public interface StylightApi {

    String CATEGORY = "category";
    String PAGE_ITEMS = "pageItems";
    String API_KEY = "X-apiKey";
    String LOCAL = "X-Locale";

    // http://api.stylight.com/rest/products?category=28107
    @GET("products")
    Observable<ProductsResponse> getProducts(
            @Header(API_KEY) String apiKey,
            @Header(LOCAL) String local,
            @Query(CATEGORY) int categoryId,
            @Query(PAGE_ITEMS) int pageItems);

    // http://api.stylight.com/rest/posts?category=fashion
    @GET("posts")
    Observable<PostsResponse> getPosts(
            @Header(API_KEY) String apiKey,
            @Header(LOCAL) String local,
            @Query(CATEGORY) String categorySlug,
            @Query(PAGE_ITEMS) int pageItems);
}
