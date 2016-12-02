package com.mirhoseini.stylight.util;

import rx.Scheduler;

/**
 * Created by Mohsen on 02/12/2016.
 */

public interface SchedulerProvider {

    Scheduler mainThread();

    Scheduler backgroundThread();

}
