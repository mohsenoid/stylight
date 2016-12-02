package com.mirhoseini.stylight.products;

import dagger.Subcomponent;

/**
 * Created by Mohsen on 02/12/2016.
 */

@Products
@Subcomponent(modules = {
        AppProductsModule.class
})
public interface ProductsSubComponent {

    void inject(ProductsFragment fragment);

}
