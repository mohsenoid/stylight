package com.mirhoseini.stylight.products;


import com.mirhoseini.stylight.BuildConfig;
import com.mirhoseini.stylight.MainActivity;
import com.mirhoseini.stylight.support.ShadowSnackbar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by Mohsen on 02/12/2016.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, shadows = {ShadowSnackbar.class})
public class ProductsFragmentRobolectricTest {

    private MainActivity activity;
    private ProductsFragment fragment;

    @Before
    public void setUp() throws Exception {
        // setup activity
        activity = Robolectric.setupActivity(MainActivity.class);
        assertNotNull(activity);

        // setup fragment
        fragment = (ProductsFragment) activity.getSupportFragmentManager().findFragmentByTag(MainActivity.TAG_PRODUCTS_FRAGMENT_CLOTHING);
        assertNotNull(fragment);
    }

    @Test
    public void testOnDetach() throws Exception {
        fragment.onDetach();

        assertNull(fragment.listener);
        assertNull(fragment.presenter);
    }

}