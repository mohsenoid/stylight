package com.mirhoseini.stylight.products;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.mirhoseini.stylight.util.AppConstants;
import com.mirhoseini.stylight.util.GridSpacingItemDecoration;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mohsen on 02/12/2016.
 */

@Module
public class AppProductsModule extends ProductsModule {

    private final Context context;
    private final ProductsFragment.OnListFragmentInteractionListener listener;
    private final int spanCount;

    AppProductsModule(Context context, ProductsFragment fragment, int spanCount) {
        super(fragment);

        this.context = context;
        this.spanCount = spanCount;

        if (context instanceof ProductsFragment.OnListFragmentInteractionListener) {
            listener = (ProductsFragment.OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Provides
    @Products
    ProductsFragment.OnListFragmentInteractionListener provideOnListFragmentInteractionListener() {
        return listener;
    }

    @Provides
    @Products
    LinearLayoutManager provideLayoutManager() {
        return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    }

    @Provides
    @Products
    GridSpacingItemDecoration provideGridSpacingItemDecoration() {
        return new GridSpacingItemDecoration(spanCount, AppConstants.RECYCLER_VIEW_ITEM_SPACE, true, 0);
    }

}
