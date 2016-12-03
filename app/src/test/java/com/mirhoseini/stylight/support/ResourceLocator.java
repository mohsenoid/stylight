package com.mirhoseini.stylight.support;

import android.support.annotation.StringRes;

import org.robolectric.RuntimeEnvironment;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class ResourceLocator {

    public static String getString(@StringRes int id) {
        return RuntimeEnvironment.application.getString(id);
    }

}
