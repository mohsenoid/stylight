package com.mirhoseini.stylight.util;

import android.content.Context;

import com.mirhoseini.utils.Utils;

import javax.inject.Inject;

/**
 * Created by Mohsen on 18/11/2016.
 */

/**
 * Application State Manager which represent states required by core-lib module
 */
public class AppStateManager implements StateManager {

    private final Context context;

    @Inject
    public AppStateManager(Context context) {
        this.context = context;
    }

    @Override
    public boolean isConnect() {
        return Utils.isConnected(context);
    }
}
