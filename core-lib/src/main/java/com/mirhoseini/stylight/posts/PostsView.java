package com.mirhoseini.stylight.posts;


import com.mirhoseini.stylight.base.BaseView;
import com.stylight.api.model.Post;

import java.util.List;

/**
 * Created by Mohsen on 02/12/2016.
 */

interface PostsView extends BaseView {

    void setPosts(List<Post> posts);

    void showRetryMessage(Throwable throwable);

    void showError(Throwable throwable);

    void showProgress();

    void hideProgress();

}
