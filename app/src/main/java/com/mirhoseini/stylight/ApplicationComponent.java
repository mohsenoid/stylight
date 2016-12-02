package com.mirhoseini.stylight;

import com.mirhoseini.stylight.domain.ApiModule;
import com.mirhoseini.stylight.domain.ClientModule;
import com.mirhoseini.stylight.posts.AppPostsModule;
import com.mirhoseini.stylight.posts.PostsSubComponent;
import com.mirhoseini.stylight.products.AppProductsModule;
import com.mirhoseini.stylight.products.ProductsSubComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mohsen on 02/12/2016.
 */

@Singleton
@Component(modules = {
        AndroidModule.class,
        ApplicationModule.class,
        ApiModule.class,
        ClientModule.class
})
public interface ApplicationComponent {

    void inject(MainActivity activity);

    PostsSubComponent plus(AppPostsModule module);

    ProductsSubComponent plus(AppProductsModule module);

}