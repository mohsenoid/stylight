package com.mirhoseini.stylight;


import com.mirhoseini.stylight.domain.ApiTestModule;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class StylightTestApplication extends StylightApplicationImpl {

    @Override
    public ApplicationTestComponent createComponent() {
        return DaggerApplicationTestComponent
                .builder()
                .androidModule(new AndroidModule(this))
                // replace Api Module with Mock one
                .apiModule(new ApiTestModule())
                .build();
    }

}
