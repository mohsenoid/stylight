package com.mirhoseini.stylight.posts.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.rxbinding.view.RxView;
import com.mirhoseini.stylight.R;
import com.stylight.api.model.Post;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class PostsRecyclerViewAdapter extends RecyclerView.Adapter<PostViewHolder> {

    private ArrayList<Post> posts = new ArrayList<>();

    private PublishSubject<Post> notify = PublishSubject.create();

    @Inject
    public PostsRecyclerViewAdapter() {
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final PostViewHolder holder, int position) {
        final Post post = posts.get(position);

        holder.setPost(post);

        RxView.clicks(holder.view)
                .map(aVoid -> holder.getPost())
                .subscribe(notify::onNext);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Post> posts) {
        this.posts = new ArrayList<>(posts);
    }

    public Observable<Post> asObservable() {
        return notify.asObservable();
    }
}