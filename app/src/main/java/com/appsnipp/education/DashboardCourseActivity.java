/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;

import com.appsnipp.education.adapter.CourseRecyclerAdapter;
import com.appsnipp.education.model.CourseCard;

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
