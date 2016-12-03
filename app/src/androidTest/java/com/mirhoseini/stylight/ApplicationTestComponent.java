package com.mirhoseini.stylight;

import com.mirhoseini.stylight.domain.ApiModule;
import com.mirhoseini.stylight.domain.ClientModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Mohsen on 02/12/2016.
 */

@Singleton
@Component(modules = {
        AndroidModule.class,
        ApplicationModule.class,
        ApiModule.class,
        ClientModule.class
})
interface ApplicationTestComponent extends ApplicationComponent {

    void inject(MainActivityTest activity);

}