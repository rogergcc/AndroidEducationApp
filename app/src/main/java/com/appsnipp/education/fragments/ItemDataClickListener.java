/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education.fragments;

import android.widget.ImageView;

import com.appsnipp.education.matchcourses.Item;
import com.appsnipp.education.model.CourseCard;

public interface ItemDataClickListener {

    void onScrollPagerItemClick(Item courseCard, ImageView imageView); // Shoud use imageview to make the shared animation between the two activity

}
