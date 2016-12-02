package com.mirhoseini.stylight.products;


import com.mirhoseini.stylight.base.BasePresenter;

/**
 * Created by Mohsen on 02/12/2016.
 */

interface ProductsPresenter extends BasePresenter<ProductsView> {

    void loadProducts(boolean isConnected, int categoryId, int itemCounts);

}
