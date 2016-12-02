package com.mirhoseini.stylight.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mirhoseini.stylight.ApplicationComponent;
import com.mirhoseini.stylight.StylightApplication;

/**
 * Created by Mohsen on 02/12/2016.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injectDependencies(StylightApplication.getComponent());

        // can be used for general purpose in all Activities of Application
    }

    protected abstract void injectDependencies(ApplicationComponent component);

}
