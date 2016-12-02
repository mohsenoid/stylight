package com.mirhoseini.stylight.posts;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.mirhoseini.stylight.products.ProductsFragment;
import com.mirhoseini.stylight.util.AppConstants;
import com.mirhoseini.stylight.util.GridSpacingItemDecoration;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mohsen on 02/12/2016.
 */

@Module
public class AppPostsModule extends PostsModule {

    private final Context context;
    private final PostsFragment.OnListFragmentInteractionListener listener;

    AppPostsModule(Context context, PostsFragment fragment) {
        super(fragment);

        this.context = context;

        if (context instanceof ProductsFragment.OnListFragmentInteractionListener) {
            listener = (PostsFragment.OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Provides
    @Posts
    PostsFragment.OnListFragmentInteractionListener provideOnListFragmentInteractionListener() {
        return listener;
    }

    @Provides
    @Posts
    public LinearLayoutManager provideLayoutManager() {
        return new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
    }

    @Provides
    @Posts
    public GridSpacingItemDecoration provideGridSpacingItemDecoration() {
        return new GridSpacingItemDecoration(1, AppConstants.RECYCLER_VIEW_ITEM_SPACE, true, 1);
    }

}
