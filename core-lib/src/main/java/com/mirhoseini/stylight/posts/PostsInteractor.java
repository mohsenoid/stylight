package com.mirhoseini.stylight.posts;


import com.mirhoseini.stylight.base.BaseInteractor;
import com.stylight.api.PostsResponse;

import rx.Observable;

/**
 * Created by Mohsen on 02/12/2016.
 */

interface PostsInteractor extends BaseInteractor {

    Observable<PostsResponse> getPosts(String apiKey,
                                       String local,
                                       String categorySlug,
                                       int pageItems);
}
