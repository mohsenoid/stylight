package com.mirhoseini.stylight.products;


import com.mirhoseini.stylight.domain.client.StylightApi;
import com.mirhoseini.stylight.util.SchedulerProvider;
import com.stylight.api.ProductsResponse;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.subjects.ReplaySubject;

/**
 * Created by Mohsen on 02/12/2016.
 */

class ProductsInteractorImpl implements ProductsInteractor {

    private StylightApi api;
    private SchedulerProvider scheduler;

    private ReplaySubject<ProductsResponse> productsSubject;
    private Subscription productsSubscription;

    @Inject
    public ProductsInteractorImpl(StylightApi api, SchedulerProvider scheduler) {
        this.api = api;
        this.scheduler = scheduler;
    }

    @Override
    public Observable<ProductsResponse> getProducts(String apiKey,
                                                    String local,
                                                    int categoryId,
                                                    int pageItems) {
        if (productsSubscription == null || productsSubscription.isUnsubscribed()) {
            productsSubject = ReplaySubject.create();

            productsSubscription = api.getProducts(apiKey, local, categoryId, pageItems)
                    .subscribeOn(scheduler.backgroundThread())
                    .subscribe(productsSubject);
        }

        return productsSubject.asObservable();
    }


    @Override
    public void unbind() {
        if (productsSubscription != null && !productsSubscription.isUnsubscribed())
            productsSubscription.unsubscribe();
    }

}
