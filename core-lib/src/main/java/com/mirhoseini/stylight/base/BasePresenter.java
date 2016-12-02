package com.mirhoseini.stylight.base;

/**
 * Created by Mohsen on 02/12/2016.
 */

public interface BasePresenter<T> {

    void bind(T view);

    void unbind();

}
