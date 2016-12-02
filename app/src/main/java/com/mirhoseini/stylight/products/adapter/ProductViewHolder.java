package com.mirhoseini.stylight.products.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mirhoseini.stylight.BR;
import com.stylight.api.model.Product;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class ProductViewHolder extends RecyclerView.ViewHolder {
    public final View view;
    private Product product;
    private ViewDataBinding binding;

    public ProductViewHolder(View view) {
        super(view);
        this.view = view;

        binding = DataBindingUtil.bind(view);

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;

        binding.setVariable(BR.product, product);
        binding.executePendingBindings();
    }

}
