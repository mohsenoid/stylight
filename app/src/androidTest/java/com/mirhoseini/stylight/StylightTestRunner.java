package com.mirhoseini.stylight;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class StylightTestRunner extends AndroidJUnitRunner {

    @Override
    public Application newApplication(ClassLoader classLoader, String className, Context context)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        // replace Application class with mock one
        return super.newApplication(classLoader, StylightTestApplication.class.getName(), context);
    }

}
