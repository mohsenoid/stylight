package com.mirhoseini.stylight.posts;

import dagger.Subcomponent;

/**
 * Created by Mohsen on 02/12/2016.
 */

@Posts
@Subcomponent(modules = {
        AppPostsModule.class
})
public interface PostsSubComponent {

    void inject(PostsFragment fragment);

}
