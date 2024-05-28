/*
 * Copyright (c) 2024. rogergcc
 */

package com.appsnipp.education.ui.listeners;

import android.widget.ImageView;

/**
 * Created on mayo.
 * year 2024 .
 */
public interface ItemClickListener<T> {
    void onItemClick(T item, ImageView imageView);
}