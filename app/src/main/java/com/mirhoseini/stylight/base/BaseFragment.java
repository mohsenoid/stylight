package com.mirhoseini.stylight.base;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.mirhoseini.stylight.ApplicationComponent;
import com.mirhoseini.stylight.StylightApplication;

/**
 * Created by Mohsen on 02/12/2016.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        injectDependencies(StylightApplication.getComponent(), context);

        // can be used for general purpose in all Fragments of Application
    }

    protected abstract void injectDependencies(ApplicationComponent component, Context context);

}