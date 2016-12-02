package com.mirhoseini.stylight.posts;

import com.mirhoseini.stylight.util.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Named;

import rx.Subscription;
import rx.subscriptions.Subscriptions;

/**
 * Created by Mohsen on 02/12/2016.
 */

class PostsPresenterImpl implements PostsPresenter {

    @Inject
    PostsInteractor interactor;

    private PostsView view;
    private Subscription subscription = Subscriptions.empty();
    private SchedulerProvider scheduler;
    private String apiKey;
    private String local;

    @Inject
    public PostsPresenterImpl(SchedulerProvider scheduler, @Named("apiKey") String apiKey, @Named("local") String local) {
        this.scheduler = scheduler;
        this.apiKey = apiKey;
        this.local = local;
    }

    @Override
    public void bind(PostsView view) {
        this.view = view;
    }


    @Override
    public void loadPosts(boolean isConnected, String categorySlug, int pageItems) {
        if (null != view) {
            view.showProgress();
        }

        subscription = interactor.getPosts(apiKey, local, categorySlug, pageItems)
                .observeOn(scheduler.mainThread())
                .subscribe(postsResponse -> {
                            if (null != view) {
                                view.hideProgress();
                                view.setPosts(postsResponse.getPosts());

                                if (!isConnected)
                                    view.showOfflineMessage();
                            }
                        },
                        // handle exceptions
                        throwable -> {
                            if (null != view) {
                                view.hideProgress();
                            }

                            if (isConnected) {
                                if (null != view) {
                                    view.showRetryMessage(throwable);
                                }
                            } else {
                                if (null != view) {
                                    view.showOfflineMessage();
                                }
                            }
                        });
    }

    @Override
    public void unbind() {
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();

        interactor.unbind();

        view = null;
        interactor = null;
    }
}
