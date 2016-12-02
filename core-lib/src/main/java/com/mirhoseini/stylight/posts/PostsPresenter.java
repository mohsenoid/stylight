package com.mirhoseini.stylight.posts;


import com.mirhoseini.stylight.base.BasePresenter;

/**
 * Created by Mohsen on 02/12/2016.
 */

interface PostsPresenter extends BasePresenter<PostsView> {

    void loadPosts(boolean isConnected, String categorySlug, int itemCounts);

}
