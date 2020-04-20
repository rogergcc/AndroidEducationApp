/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.appsnipp.education.adapter.CourseRecyclerAdapter;
import com.appsnipp.education.adapter.CoursesItemClickListener;
import com.appsnipp.education.model.CourseCard;

import java.util.ArrayList;
import java.util.List;

public class CourseStaggedActivity extends AppCompatActivity
        implements CoursesItemClickListener {
    private CourseRecyclerAdapter adapter;
    private RecyclerView recyclerView;
    private List<CourseCard> courseCards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_course_stagged);

        recyclerView = findViewById(R.id.rv_courses);

        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );
        recyclerView.setClipToPadding(false);
        recyclerView.setHasFixedSize(true);

        courseCards = new ArrayList<>();

        courseCards.add(new CourseCard(1,R.drawable.course_design_thinking, "Desing Thinking", "19 courses"));
        courseCards.add(new CourseCard(2,R.drawable.course_design_coding, "Coding", "14 courses"));
        courseCards.add(new CourseCard(3,R.drawable.course_design_marketing, "Marketing", "24 courses"));
        courseCards.add(new CourseCard(4,R.drawable.course_design_securityexpert, "Security Expert", "18 courses"));
        courseCards.add(new CourseCard(5,R.drawable.course_design_whatisthisshit, "Locations", "21 courses"));
        courseCards.add(new CourseCard(6,R.drawable.course_design_coding, "Big Data", "10 courses"));

        adapter = new CourseRecyclerAdapter(this, courseCards, this);

//        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.card_margin);
//        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

        recyclerView.setAdapter(adapter);


    }


    @Override
    public void onDashboardCourseClick(CourseCard courseCard, ImageView imageView) {

        Toast.makeText(this, courseCard.getCourseTitle(), Toast.LENGTH_LONG).show();

    }


    //    https://stackoverflow.com/questions/28531996/android-recyclerview-gridlayoutmanager-column-spacing
    public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;

        public SpacesItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildLayoutPosition(view) == 0) {
                outRect.top = space;
            } else {
                outRect.top = 0;
            }
        }
    }
}
