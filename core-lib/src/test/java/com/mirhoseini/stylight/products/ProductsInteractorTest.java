package com.mirhoseini.stylight.products;

import com.mirhoseini.stylight.domain.client.StylightApi;
import com.mirhoseini.stylight.util.SchedulerProvider;
import com.stylight.api.ProductsResponse;
import com.stylight.api.model.Currency;
import com.stylight.api.model.Image;
import com.stylight.api.model.Product;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import rx.Observable;
import rx.observers.TestSubscriber;
import rx.schedulers.Schedulers;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class ProductsInteractorTest {

    private static final String TEST_PRODUCT_NAME = "Name";
    private static final double TEST_PRODUCT_PRICE = 2.99;
    private static final String TEST_PRODUCT_CURRENCY_SYMBOL = "€";
    private static final String TEST_PRODUCT_CURRENCY_NAME = "Euro";

    private ProductsInteractor interactor;
    private ProductsResponse expectedResult;

    @Before
    public void setup() {
        StylightApi api = mock(StylightApi.class);
        SchedulerProvider scheduler = mock(SchedulerProvider.class);

        // Set up the stub we want to return in the mock
        ArrayList<Image> images = new ArrayList<>();
        Image image = new Image();
        images.add(image);

        Currency currency = new Currency(0, TEST_PRODUCT_CURRENCY_NAME, TEST_PRODUCT_CURRENCY_SYMBOL);

        Product product = new Product(0, TEST_PRODUCT_NAME, TEST_PRODUCT_PRICE, currency, "", images);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);

        // put the test data in a test api result
        expectedResult = new ProductsResponse(0, 1, 1, "", products);

        // mock scheduler to run immediately
        when(scheduler.mainThread())
                .thenReturn(Schedulers.immediate());
        when(scheduler.backgroundThread())
                .thenReturn(Schedulers.immediate());

        // mock api result with expected result
        when(api.getProducts(anyString(), anyString(), anyInt(), anyInt()))
                .thenReturn(Observable.just(expectedResult));

        // create a real new interactor using mocked api and scheduler
        interactor = new ProductsInteractorImpl(api, scheduler);
    }

    @Test
    public void testLoadProducts() throws Exception {
        TestSubscriber<ProductsResponse> testSubscriber = new TestSubscriber<>();

        // call interactor with some random params
        interactor.getProducts("", "", 0, 1)
                .subscribe(testSubscriber);

        // it must return the expectedResult with no error
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(Collections.singletonList(expectedResult));
    }
}
