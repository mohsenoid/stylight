package com.mirhoseini.stylight.products;

import com.mirhoseini.stylight.util.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by Mohsen on 02/12/2016.
 */

class ProductsPresenterImpl implements ProductsPresenter {

    @Inject
    ProductsInteractor interactor;

    private ProductsView view;
    private Subscription subscription = Subscriptions.empty();
    private SchedulerProvider scheduler;
    private String apiKey;
    private String local;

    @Inject
    public ProductsPresenterImpl(SchedulerProvider scheduler, @Named("apiKey") String apiKey, @Named("local") String local) {
        this.scheduler = scheduler;
        this.apiKey = apiKey;
        this.local = local;
    }

    @Override
    public void bind(ProductsView view) {
        this.view = view;
    }


    @Override
    public void loadProducts(boolean isConnected, int categoryId, int pageItems) {
        if (null != view) {
            view.showProgress();
        }

        subscription = interactor.getProducts(apiKey, local, categoryId, pageItems)
                .observeOn(scheduler.mainThread())
                .subscribe(productsResponse -> {
                            if (null != view) {
                                view.hideProgress();
                                view.setProducts(productsResponse.getProducts());

                                if (!isConnected)
                                    view.showOfflineMessage();
                            }
                        },
                        // handle exceptions
                        throwable -> {
                            if (null != view) {
                                view.hideProgress();
                            }

                            if (isConnected) {
                                if (null != view) {
                                    view.showRetryMessage(throwable);
                                }
                            } else {
                                if (null != view) {
                                    view.showOfflineMessage();
                                }
                            }
                        });
    }

    @Override
    public void unbind() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();

        interactor.unbind();

        view = null;
        interactor = null;
    }
}
