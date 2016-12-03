package com.mirhoseini.stylight.domain;

import com.mirhoseini.stylight.domain.client.StylightApi;

import retrofit2.Retrofit;

import static org.mockito.Mockito.mock;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class ApiTestModule extends ApiModule {

    @Override
    public StylightApi provideStylightApi(Retrofit retrofit) {
        // replace real StylightApi with Mock one
        return mock(StylightApi.class);
    }

}
