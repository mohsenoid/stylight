package com.mirhoseini.stylight.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.mirhoseini.stylight.R;
import com.squareup.picasso.Picasso;


/**
 * Created by Mohsen on 02/12/2016.
 */

public class CustomBindingAdapter {

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView imageView, String url) {
        if (null == url) {
            imageView.setImageResource(R.drawable.default_image);
        } else {
            Picasso.with(imageView.getContext())
                    .load(url)
                    .error(R.drawable.default_image)
                    .into(imageView);
        }
    }

}
