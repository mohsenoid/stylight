package com.mirhoseini.stylight.posts;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Mohsen on 02/12/2016.
 */

@Module
class PostsModule {

    private PostsView view;

    PostsModule(PostsView view) {
        this.view = view;
    }

    @Provides
    public PostsView provideView() {
        return view;
    }

    @Provides
    @Posts
    public PostsInteractor provideInteractor(PostsInteractorImpl interactor) {
        return interactor;
    }

    @Provides
    @Posts
    public PostsPresenter providePresenter(PostsPresenterImpl presenter) {
        presenter.bind(view);
        return presenter;
    }

}
