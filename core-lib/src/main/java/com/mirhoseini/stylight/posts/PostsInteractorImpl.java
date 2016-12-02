package com.mirhoseini.stylight.posts;


import com.mirhoseini.stylight.domain.client.StylightApi;
import com.mirhoseini.stylight.util.SchedulerProvider;
import com.stylight.api.PostsResponse;

import javax.inject.Inject;

import rx.Observable;
import rx.Subscription;
import rx.subjects.ReplaySubject;

/**
 * Created by Mohsen on 02/12/2016.
 */

class PostsInteractorImpl implements PostsInteractor {

    private StylightApi api;
    private SchedulerProvider scheduler;

    private ReplaySubject<PostsResponse> postsSubject;
    private Subscription postsSubscription;

    @Inject
    public PostsInteractorImpl(StylightApi api, SchedulerProvider scheduler) {
        this.api = api;
        this.scheduler = scheduler;
    }

    @Override
    public Observable<PostsResponse> getPosts(String apiKey,
                                              String local,
                                              String categorySlug,
                                              int pageItems) {
        if (postsSubscription == null || postsSubscription.isUnsubscribed()) {
            postsSubject = ReplaySubject.create();

            postsSubscription = api.getPosts(apiKey, local, categorySlug, pageItems)
                    .subscribeOn(scheduler.backgroundThread())
                    .subscribe(postsSubject);
        }

        return postsSubject.asObservable();
    }


    @Override
    public void unbind() {
        if (postsSubscription != null && !postsSubscription.isUnsubscribed())
            postsSubscription.unsubscribe();
    }

}
