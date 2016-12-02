package com.mirhoseini.stylight.posts.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mirhoseini.stylight.BR;
import com.stylight.api.model.Post;

/**
 * Created by Mohsen on 02/12/2016.
 */

class PostViewHolder extends RecyclerView.ViewHolder {
    public final View view;
    private Post post;
    private ViewDataBinding binding;

    PostViewHolder(View view) {
        super(view);
        this.view = view;

        binding = DataBindingUtil.bind(view);

    }

    Post getPost() {
        return post;
    }

    void setPost(Post post) {
        this.post = post;

        binding.setVariable(BR.post, post);
        binding.executePendingBindings();
    }

}
