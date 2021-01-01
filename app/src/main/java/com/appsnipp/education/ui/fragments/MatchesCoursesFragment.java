/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.appsnipp.education.R;
import com.appsnipp.education.databinding.FragmentMatchesCoursesBinding;
import com.appsnipp.education.ui.adapter.CourseTopicsViewPager;
import com.appsnipp.education.ui.helpers.HorizontalMarginItemDecoration;
import com.appsnipp.education.ui.helpers.MyUtilsApp;
import com.appsnipp.education.ui.listeners.MatchCourseClickListener;
import com.appsnipp.education.ui.model.MatchCourse;
import com.appsnipp.education.ui.model.MyMatchesCourses;

import java.util.List;
import java.util.Locale;

import static java.lang.Math.abs;


public class MatchesCoursesFragment extends Fragment
        implements
//        DiscreteScrollView.OnItemChangedListener<MatchesCoursesAdapter.ViewHolder>
        MatchCourseClickListener {

    private static final String TAG = "MatchesCoursesFragment";
    FragmentMatchesCoursesBinding binding;
    Context mcontext;
    private List<MatchCourse> data;
    private MyMatchesCourses myMatchesCourses;

    public MatchesCoursesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_matches_courses, container, false);
        binding = FragmentMatchesCoursesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        mcontext = this.getContext();

        myMatchesCourses = MyMatchesCourses.get();
        data = myMatchesCourses.getData();


//        int currentItem = getCurrentItem();
        int currentItem = 1;
        setupViewpager(currentItem, data);

        return view;
    }


    private void setupViewpager(int currentItem, List<MatchCourse> matchCourseList) {
        CourseTopicsViewPager courseTopicsViewPager = new CourseTopicsViewPager(matchCourseList, mcontext, this);
        binding.viewPager.setAdapter(courseTopicsViewPager);
        // set selected item
        binding.viewPager.setCurrentItem(currentItem);
        // You need to retain one page on each side so that the next and previous items are visible
        binding.viewPager.setOffscreenPageLimit(1);
        // Add a PageTransformer that translates the next and previous items horizontally
        // towards the center of the screen, which makes them visible
        int nextItemVisiblePx = (int) getResources().getDimension(R.dimen.viewpager_next_item_visible);
        int currentItemHorizontalMarginPx = (int) getResources().getDimension(R.dimen.viewpager_current_item_horizontal_margin);
        int pageTranslationX = nextItemVisiblePx + currentItemHorizontalMarginPx;
        ViewPager2.PageTransformer pageTransformer = (page, position) -> {
            page.setTranslationX(-pageTranslationX * position);
            // Next line scales the item's height. You can remove it if you don't want this effect
            page.setScaleY(1 - (0.15f * abs(position)));
            // If you want a fading effect uncomment the next line:
            // page.alpha = 0.25f + (1 - abs(position))
        };
        binding.viewPager.setPageTransformer(pageTransformer);
        binding.viewPager.addItemDecoration(new HorizontalMarginItemDecoration(
                mcontext, R.dimen.viewpager_current_item_horizontal_margin_testing,
                R.dimen.viewpager_next_item_visible_testing)
        );
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//                countTxtView.setText(String.format(Locale.ENGLISH,"%d/%d", position+1, matchCourseList.size()));

                MyUtilsApp.showLog(TAG, String.format(Locale.ENGLISH, "%d/%d", position + 1, matchCourseList.size()));
            }
        });
    }

//    @Override
//    public void onCurrentItemChanged(@Nullable MatchesCoursesAdapter.ViewHolder viewHolder, int adapterPosition) {
//
//        MyUtilsApp.showLog(TAG, "ItemChanged adapterposition: " + adapterPosition);
//
//    }

    @Override
    public void onScrollPagerItemClick(MatchCourse courseCard, ImageView imageView) {
        MyUtilsApp.showLog(TAG, "LogD onScrollPagerItemClick : " + courseCard.toString());

        MyUtilsApp.showToast(mcontext, courseCard.getName());
        //Now, this has dynamic data from myMatchesCourses.getData();.
        //Could use the Id as unique value for go to new activity
//        Intent intentGetStarted;
//        intentGetStarted = new Intent(mcontext, YourActivity.class);
//        startActivity(intentGetStarted);
    }
}