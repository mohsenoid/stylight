package com.mirhoseini.stylight.products;


import com.mirhoseini.stylight.base.BaseView;
import com.stylight.api.model.Product;

import java.util.List;

/**
 * Created by Mohsen on 02/12/2016.
 */

interface ProductsView extends BaseView {

    void setProducts(List<Product> products);

    void showRetryMessage(Throwable throwable);

    void showProgress();

    void hideProgress();

}
