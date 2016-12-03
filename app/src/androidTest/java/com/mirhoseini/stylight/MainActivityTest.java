package com.mirhoseini.stylight;

import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mirhoseini.stylight.domain.client.StylightApi;
import com.mirhoseini.stylight.util.Constants;
import com.stylight.api.PostsResponse;
import com.stylight.api.ProductsResponse;
import com.stylight.api.model.Category;
import com.stylight.api.model.Currency;
import com.stylight.api.model.Image;
import com.stylight.api.model.Post;
import com.stylight.api.model.Product;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import javax.inject.Inject;

import rx.Observable;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static com.mirhoseini.stylight.support.Matcher.childAtPosition;
import static org.hamcrest.Matchers.allOf;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;

/**
 * Created by Mohsen on 02/12/2016.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private static final String TEST_PRODUCT_NAME = "Name";
    private static final double TEST_PRODUCT_PRICE = 2.99;
    private static final String TEST_PRODUCT_CURRENCY_SYMBOL = "€";
    private static final String TEST_PRODUCT_CURRENCY_NAME = "Euro";

    private static final String TEST_POST_TITLE = "Title";
    private static final String TEST_POST_CATEGORY_NAME = "Category";
    private static final String TEST_POST_CATEGORY_COLOR = "FF0000";

    @Rule
    public ActivityTestRule<MainActivity> mainActivity = new ActivityTestRule<>(
            MainActivity.class,
            true,
            // false: do not launch the activity immediately
            false);
    @Inject
    StylightApi api;
    private StylightTestApplication application;
    private ProductsResponse expectedProductsResult;
    private PostsResponse expectedPostsResult;

    @Before
    public void setUp() {
        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
        application = (StylightTestApplication) instrumentation.getTargetContext().getApplicationContext();
        ApplicationTestComponent component = (ApplicationTestComponent) StylightApplication.getComponent();

        // inject mocked objects
        component.inject(this);

        // Set up the stub we want to return in the mock
        ArrayList<Image> images = new ArrayList<>();
        Image image = new Image("image.png", true, "", "", "");
        images.add(image);

        Currency currency = new Currency(0, TEST_PRODUCT_CURRENCY_NAME, TEST_PRODUCT_CURRENCY_SYMBOL);
        Product product = new Product(0, TEST_PRODUCT_NAME, TEST_PRODUCT_PRICE, currency, "", images);

        ArrayList<Product> products = new ArrayList<>();
        products.add(product);

        Category category = new Category(0, TEST_POST_CATEGORY_NAME, TEST_POST_CATEGORY_COLOR, "", "");
        Post post = new Post(0, TEST_POST_TITLE, "", category, "image.png");

        ArrayList<Post> posts = new ArrayList<>();
        posts.add(post);

        // put the test data in a test api result
        expectedProductsResult = new ProductsResponse(0, 1, 1, "", products);
        expectedPostsResult = new PostsResponse(posts, 0, 1, 1, "");


        // Set up the mock API
        when(api.getProducts(anyString(), anyString(), eq(Constants.CLOTHING_PRODUCTS_CATEGORY_ID), anyInt()))
                .thenReturn(Observable.just(expectedProductsResult));
        when(api.getProducts(anyString(), anyString(), eq(Constants.LAMPS_PRODUCTS_CATEGORY_ID), anyInt()))
                .thenReturn(Observable.just(null));
        when(api.getPosts(anyString(), anyString(), eq(Constants.FASHION_POSTS_CATEGORY_SLUG), anyInt()))
                .thenReturn(Observable.just(expectedPostsResult));
        when(api.getPosts(anyString(), anyString(), eq(Constants.LIFESTYLE_POSTS_CATEGORY_SLUG), anyInt()))
                .thenReturn(Observable.just(null));
    }

    @Test
    public void shouldBeAbleToLoadProducts() {
        // Launch the activity
        mainActivity.launchActivity(new Intent());

        ViewInteraction productName = onView(
                allOf(withId(R.id.name), withText(TEST_PRODUCT_NAME),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        productName.check(matches(withText(TEST_PRODUCT_NAME)));

        ViewInteraction productPrice = onView(
                allOf(withId(R.id.price), withText(TEST_PRODUCT_PRICE + TEST_PRODUCT_CURRENCY_SYMBOL),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.instanceOf(android.widget.FrameLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        productPrice.check(matches(withText(TEST_PRODUCT_PRICE + TEST_PRODUCT_CURRENCY_SYMBOL)));
    }

    @Test
    public void shouldBeAbleToLoadPosts() {
        // Launch the activity
        mainActivity.launchActivity(new Intent());

        ViewInteraction category = onView(
                allOf(withId(R.id.category), withText(TEST_POST_CATEGORY_NAME),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.instanceOf(android.widget.FrameLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        category.check(matches(withText(TEST_POST_CATEGORY_NAME)));

        ViewInteraction title = onView(
                allOf(withId(R.id.name), withText(TEST_POST_TITLE),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.instanceOf(android.widget.FrameLayout.class),
                                        0),
                                2),
                        isDisplayed()));
        title.check(matches(withText(TEST_POST_TITLE)));
    }

}

