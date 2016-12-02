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

    AppProductsModule(Context context, ProductsFragment fragment) {
        super(fragment);

        this.context = context;

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
    public LinearLayoutManager provideLayoutManager() {
        return new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
    }

    @Provides
    @Products
    public GridSpacingItemDecoration provideGridSpacingItemDecoration() {
        return new GridSpacingItemDecoration(1, AppConstants.RECYCLER_VIEW_ITEM_SPACE, true, 1);
    }

}
