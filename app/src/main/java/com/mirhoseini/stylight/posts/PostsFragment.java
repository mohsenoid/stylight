package com.mirhoseini.stylight.posts;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mirhoseini.stylight.ApplicationComponent;
import com.mirhoseini.stylight.R;
import com.mirhoseini.stylight.base.BaseFragment;
import com.mirhoseini.stylight.base.BaseView;
import com.mirhoseini.stylight.posts.adapter.PostsRecyclerViewAdapter;
import com.mirhoseini.stylight.util.GridSpacingItemDecoration;
import com.mirhoseini.utils.Utils;
import com.stylight.api.model.Post;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.subscriptions.CompositeSubscription;
import timber.log.Timber;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class PostsFragment extends BaseFragment implements PostsView {

    private static final String ARG_ITEM_COUNTS = "item-counts";
    private static final String ARG_CATEGORY_SLUG = "category-slug";
    private static final String ARG_TITLE = "title";
    private static final String ARG_SUBTITLE = "subtitle";

    // injecting dependencies via Dagger
    @Inject
    PostsPresenter presenter;
    @Inject
    Context context;
    @Inject
    LinearLayoutManager layoutManager;
    @Inject
    GridSpacingItemDecoration gridSpacingItemDecoration;
    @Inject
    PostsRecyclerViewAdapter adapter;
    @Inject
    PostsFragment.OnListFragmentInteractionListener listener;

    // injecting views via ButterKnife
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.subtitle)
    TextView subtitle;
    @BindView(R.id.progress)
    ProgressBar progress;
    @BindView(R.id.list)
    RecyclerView list;
    @BindView(R.id.empty)
    ViewGroup empty;
    @BindView(R.id.retry)
    ViewGroup retry;
    private CompositeSubscription subscriptions = new CompositeSubscription();
    private int itemCounts = 3;
    private String categorySlug;
    private String titleText;
    private String subtitleText;
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public PostsFragment() {
    }

    public static PostsFragment newInstance(int itemCounts, String categorySlug, String title, String subtitle) {
        PostsFragment fragment = new PostsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_ITEM_COUNTS, itemCounts);
        args.putString(ARG_CATEGORY_SLUG, categorySlug);
        args.putString(ARG_TITLE, title);
        args.putString(ARG_SUBTITLE, subtitle);
        fragment.setArguments(args);
        return fragment;
    }

    @OnClick(R.id.retry)
    void onRetryClick() {
        loadData();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            itemCounts = getArguments().getInt(ARG_ITEM_COUNTS);
            categorySlug = getArguments().getString(ARG_CATEGORY_SLUG);
            titleText = getArguments().getString(ARG_TITLE);
            subtitleText = getArguments().getString(ARG_SUBTITLE);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        subscriptions.add(
                adapter.asObservable()
                        .filter(post -> null != listener)
                        .subscribe(listener::showPost));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_posts, container, false);

        ButterKnife.bind(this, view);

        title.setText(titleText);
        subtitle.setText(subtitleText);

        initRecyclerView();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        loadData();
    }

    private void loadData() {
        presenter.loadPosts(Utils.isConnected(context), categorySlug, itemCounts);
    }

    @Override
    protected void injectDependencies(ApplicationComponent component, Context context) {
        component
                .plus(new AppPostsModule(context, this, 1))
                .inject(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;

        presenter.unbind();
        presenter = null;

        subscriptions.unsubscribe();
    }

    @Override
    public void showMessage(String message) {
        if (null != listener) {
            listener.showMessage(message);
        }
    }

    @Override
    public void showOfflineMessage() {
        if (null != listener) {
            listener.showOfflineMessage();
        }
    }

    @Override
    public void showError(Throwable throwable) {
        Timber.e(throwable, "Error!");

        Toast.makeText(context, throwable.getMessage(), Toast.LENGTH_LONG).show();
    }

    private void initRecyclerView() {
        list.setLayoutManager(layoutManager);
        list.addItemDecoration(gridSpacingItemDecoration);
        list.setNestedScrollingEnabled(false);
    }

    @Override
    public void setPosts(List<Post> posts) {
        if (posts.size() > 0) {
            list.setVisibility(View.VISIBLE);

            retry.setVisibility(View.GONE);
            empty.setVisibility(View.GONE);

            adapter.setPosts(posts);
            list.setAdapter(adapter);
        } else {
            // no data
            list.setVisibility(View.GONE);

            retry.setVisibility(View.GONE);
            empty.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showRetryMessage(Throwable throwable) {
        list.setVisibility(View.GONE);
        empty.setVisibility(View.GONE);

        retry.setVisibility(View.VISIBLE);
    }

    @Override
    public void showProgress() {
        retry.setVisibility(View.GONE);
        empty.setVisibility(View.GONE);
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
    }

    public interface OnListFragmentInteractionListener extends BaseView {

        void showPost(Post post);

    }
}
