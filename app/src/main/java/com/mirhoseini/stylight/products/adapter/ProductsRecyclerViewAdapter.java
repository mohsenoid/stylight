package com.mirhoseini.stylight.products.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jakewharton.rxbinding.view.RxView;
import com.mirhoseini.stylight.R;
import com.stylight.api.model.Product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by Mohsen on 02/12/2016.
 */

public class ProductsRecyclerViewAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private ArrayList<Product> products = new ArrayList<>();

    private PublishSubject<Product> notify = PublishSubject.create();

    @Inject
    public ProductsRecyclerViewAdapter() {
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, int position) {
        final Product product = products.get(position);

        holder.setProduct(product);

        RxView.clicks(holder.view)
                .map(aVoid -> holder.getProduct())
                .subscribe(notify::onNext);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void setProducts(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public Observable<Product> asObservable() {
        return notify.asObservable();
    }

}
