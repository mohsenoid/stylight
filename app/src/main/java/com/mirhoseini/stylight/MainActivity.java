package com.mirhoseini.stylight;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.mirhoseini.stylight.base.BaseActivity;
import com.mirhoseini.stylight.base.BaseView;
import com.mirhoseini.stylight.posts.PostsFragment;
import com.mirhoseini.stylight.products.ProductsFragment;
import com.mirhoseini.stylight.util.AppConstants;
import com.mirhoseini.stylight.util.Constants;
import com.mirhoseini.utils.Utils;
import com.stylight.api.model.Post;
import com.stylight.api.model.Product;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class MainActivity extends BaseActivity implements BaseView, PostsFragment.OnListFragmentInteractionListener, ProductsFragment.OnListFragmentInteractionListener {

    public static final String TAG_PRODUCTS_FRAGMENT_CLOTHING = "products_fragment_clothing";
    public static final String TAG_PRODUCTS_FRAGMENT_LAMP = "products_fragment_lamp";
    public static final String TAG_POSTS_FRAGMENT_FASHION = "posts_fragment_fashion";
    public static final String TAG_POSTS_FRAGMENT_LIFESTYLE = "posts_fragment_lifestyle";

    // injecting dependencies via Dagger
    @Inject
    Context context;
    @Inject
    Resources resources;

    // injecting views via ButterKnife
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private ProductsFragment fashionProductsFragment;
    private ProductsFragment lampProductsFragment;
    private PostsFragment fashionPostsFragment;
    private PostsFragment lifestylePostsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // inject views using ButterKnife
        ButterKnife.bind(this);

        setupToolbar();

        if (null == savedInstanceState) {
            createFragments();
            attachFragments();
        } else {
            findFragments();
        }

        Timber.d("Main Activity Created");
    }

    private void findFragments() {
        fashionProductsFragment = (ProductsFragment) getSupportFragmentManager().findFragmentByTag(TAG_PRODUCTS_FRAGMENT_CLOTHING);
        fashionPostsFragment = (PostsFragment) getSupportFragmentManager().findFragmentByTag(TAG_POSTS_FRAGMENT_FASHION);
        lampProductsFragment = (ProductsFragment) getSupportFragmentManager().findFragmentByTag(TAG_PRODUCTS_FRAGMENT_LAMP);
        lifestylePostsFragment = (PostsFragment) getSupportFragmentManager().findFragmentByTag(TAG_POSTS_FRAGMENT_LIFESTYLE);
    }

    private void createFragments() {
        fashionProductsFragment = ProductsFragment.newInstance(AppConstants.PRODUCTS_COUNT, Constants.CLOTHING_PRODUCTS_CATEGORY_ID, resources.getString(R.string.check_these_out), resources.getString(R.string.new_and_trending_products));
        fashionPostsFragment = PostsFragment.newInstance(AppConstants.POSTS_COUNT, Constants.FASHION_POSTS_CATEGORY_SLUG_CLOTHING, resources.getString(R.string.the_latest_fashion_news), resources.getString(R.string.get_up_to_date));
        lampProductsFragment = ProductsFragment.newInstance(AppConstants.PRODUCTS_COUNT, Constants.LAMPS_PRODUCTS_CATEGORY_ID, resources.getString(R.string.the_coolest_lamps), resources.getString(R.string.new_and_trending_products));
        lifestylePostsFragment = PostsFragment.newInstance(AppConstants.POSTS_COUNT, Constants.LIFESTYLE_POSTS_CATEGORY_SLUG_CLOTHING, resources.getString(R.string.the_latest_lifestyle_news), resources.getString(R.string.get_up_to_date));
    }

    @Override
    protected void injectDependencies(ApplicationComponent component) {
        component.inject(this);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.logo);
        getSupportActionBar().setTitle(R.string.main_title);
    }

    private void attachFragments() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();

        fragmentTransaction.replace(R.id.fragment_products_clothing, fashionProductsFragment, TAG_PRODUCTS_FRAGMENT_CLOTHING);
        fragmentTransaction.replace(R.id.fragment_posts_fashion, fashionPostsFragment, TAG_POSTS_FRAGMENT_FASHION);
        fragmentTransaction.replace(R.id.fragment_products_lamp, lampProductsFragment, TAG_PRODUCTS_FRAGMENT_LAMP);
        fragmentTransaction.replace(R.id.fragment_posts_lifestyle, lifestylePostsFragment, TAG_POSTS_FRAGMENT_LIFESTYLE);

        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    public void showMessage(String message) {
        Timber.d("Showing Message: %s", message);

        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showOfflineMessage() {
        Timber.d("Showing Offline Message");

        Snackbar.make(toolbar, R.string.offline_message, Snackbar.LENGTH_LONG)
                .setAction(R.string.go_online, v -> startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS)))
                .setActionTextColor(Color.GREEN)
                .show();
    }


    @Override
    public void showPost(Post post) {
        Utils.openWebsite(context, post.getLink());
    }

    @Override
    public void showProduct(Product product) {
        Utils.openWebsite(context, product.getUrl());
    }
}
