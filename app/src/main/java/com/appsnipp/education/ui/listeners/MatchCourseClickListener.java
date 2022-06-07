/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education.ui.listeners;

import android.widget.ImageView;

import com.appsnipp.education.ui.model.MatchCourse;

public interface MatchCourseClickListener {

    void onScrollPagerItemClick(MatchCourse courseCard, ImageView imageView); // Shoud use imageview to make the shared animation between the two activity

}
