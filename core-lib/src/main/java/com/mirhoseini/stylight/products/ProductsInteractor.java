package com.mirhoseini.stylight.products;


import com.mirhoseini.stylight.base.BaseInteractor;
import com.stylight.api.ProductsResponse;

import rx.Observable;

/**
 * Created by Mohsen on 02/12/2016.
 */

interface ProductsInteractor extends BaseInteractor {

    Observable<ProductsResponse> getProducts(String apiKey,
                                             String local,
                                             int categoryId,
                                             int pageItems);
}
