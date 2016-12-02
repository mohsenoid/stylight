package com.mirhoseini.stylight.products;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mohsen on 02/12/2016.
 */

@Module
class ProductsModule {

    private ProductsView view;

    ProductsModule(ProductsView view) {
        this.view = view;
    }

    @Provides
    public ProductsView provideView() {
        return view;
    }

    @Provides
    @Products
    public ProductsInteractor provideInteractor(ProductsInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @Products
    public ProductsPresenter providePresenter(ProductsPresenterImpl presenter) {
        presenter.bind(view);
        return presenter;
    }

}
