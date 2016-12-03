package com.mirhoseini.stylight;


import com.mirhoseini.stylight.support.ShadowSnackbar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowToast;

import static com.mirhoseini.stylight.support.Assert.assertAlertDialogIsShown;
import static com.mirhoseini.stylight.support.Assert.assertSnackbarIsShown;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;


/**
 * Created by Mohsen on 02/12/2016.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21, shadows = {ShadowSnackbar.class})
public class MainActivityRobolectricTest {

    private final static String TEST_TEXT = "This is a test text.";
    private MainActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(MainActivity.class);

        assertNotNull(activity);
    }

    @Test
    public void testShowToastMessage() throws Exception {
        activity.showMessage(TEST_TEXT);

        assertThat(TEST_TEXT, equalTo(ShadowToast.getTextOfLatestToast()));
    }

    @Test
    public void testShowOfflineMessage() throws Exception {
        activity.showOfflineMessage(false);

        assertSnackbarIsShown(R.string.offline_message);
    }

    @Test
    public void testShowForceOfflineMessage() throws Exception {
        activity.showOfflineMessage(true);

        assertAlertDialogIsShown(R.string.utils__no_connection_title, R.string.utils__no_connection);
    }

}
