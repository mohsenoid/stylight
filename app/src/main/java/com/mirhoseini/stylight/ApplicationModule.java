package com.mirhoseini.stylight;

import android.content.Context;

import com.mirhoseini.stylight.util.AppConstants;
import com.mirhoseini.stylight.util.AppSchedulerProvider;
import com.mirhoseini.stylight.util.AppStateManager;
import com.mirhoseini.stylight.util.Constants;
import com.mirhoseini.stylight.util.SchedulerProvider;
import com.mirhoseini.stylight.util.StateManager;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;

/**
 * Created by Mohsen on 02/12/2016.
 */

@Module
public class ApplicationModule {
    @Provides
    @Singleton
    @Named("isDebug")
    boolean provideIsDebug() {
        return BuildConfig.DEBUG;
    }

    @Provides
    @Singleton
    @Named("networkTimeoutInSeconds")
    int provideNetworkTimeoutInSeconds() {
        return Constants.NETWORK_CONNECTION_TIMEOUT;
    }

    @Provides
    @Singleton
    HttpUrl provideEndpoint() {
        return HttpUrl.parse(Constants.BASE_URL);
    }

    @Provides
    @Singleton
    SchedulerProvider provideAppScheduler() {
        return new AppSchedulerProvider();
    }

    @Provides
    @Singleton
    @Named("cacheSize")
    long provideCacheSize() {
        return Constants.CACHE_SIZE;
    }

    @Provides
    @Singleton
    @Named("cacheMaxAge")
    int provideCacheMaxAgeMinutes() {
        return Constants.CACHE_MAX_AGE;
    }

    @Provides
    @Singleton
    @Named("cacheMaxStale")
    int provideCacheMaxStaleDays() {
        return Constants.CACHE_MAX_STALE;
    }

    @Provides
    @Singleton
    @Named("cacheDir")
    File provideCacheDir(Context context) {
        return context.getCacheDir();
    }

    @Provides
    @Singleton
    @Named("apiKey")
    String provideApiKey() {
        return AppConstants.API_KEY;
    }

    @Provides
    @Singleton
    @Named("local")
    String provideLocal() {
        return AppConstants.LOCALE_DE;
    }

    @Provides
    @Singleton
    StateManager provideStateManager(AppStateManager stateManager) {
        return stateManager;
    }

    @Provides
    @Singleton
    @Named("retryCount")
    int provideApiRetryCount() {
        return AppConstants.API_RETRY_COUNT;
    }
}
