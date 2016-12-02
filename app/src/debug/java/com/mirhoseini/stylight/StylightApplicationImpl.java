package com.mirhoseini.stylight;

import timber.log.Timber;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class StylightApplicationImpl extends StylightApplication {

    @Override
    public void initApplication() {

        // initialize Timber in debug version to log
        Timber.plant(new Timber.DebugTree() {
            @Override
            protected String createStackElementTag(StackTraceElement element) {
                // adding line number to logs
                return super.createStackElementTag(element) + ":" + element.getLineNumber();
            }
        });

    }
}
