/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education;

import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.education.ui.adapter.CourseRecyclerAdapter;
import com.appsnipp.education.ui.model.CourseCard;

import java.util.List;

public class DashboardCourseActivity extends AppCompatActivity {

    private CourseRecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private List<CourseCard> courseCards;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard_course);


    }
}
