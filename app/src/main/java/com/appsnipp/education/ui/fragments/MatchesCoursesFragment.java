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
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.appsnipp.education.databinding.FragmentMatchesCoursesBinding;
import com.appsnipp.education.ui.adapter.MatchesCoursesAdapter;
import com.appsnipp.education.ui.helpers.DiscreteScrollViewOptions;
import com.appsnipp.education.ui.helpers.MyUtilsApp;
import com.appsnipp.education.ui.listeners.MatchCourseClickListener;
import com.appsnipp.education.ui.model.MatchCourse;
import com.appsnipp.education.ui.model.MyMatchesCourses;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.List;


public class MatchesCoursesFragment extends Fragment
        implements DiscreteScrollView.OnItemChangedListener<MatchesCoursesAdapter.ViewHolder>
        , MatchCourseClickListener {

    private static final String TAG = "MatchesCoursesFragment";
    FragmentMatchesCoursesBinding binding;
    Context mcontext;
    private List<MatchCourse> data;
    private MyMatchesCourses myMatchesCourses;
    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter<?> infiniteAdapter;

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
        binding.itemPicker.setOrientation(DSVOrientation.HORIZONTAL);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new MatchesCoursesAdapter(data, this));

        binding.itemPicker.setAdapter(infiniteAdapter);
        binding.itemPicker.setItemTransitionTimeMillis(DiscreteScrollViewOptions.getTransitionTime());


        DiscreteScrollViewOptions.smoothScrollToUserSelectedPosition(binding.itemPicker, view);
        binding.itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());

        binding.itemPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyUtilsApp.showLog(TAG, "mClick: " + itemPicker.getCurrentItem());

            }
        });

        binding.itemPicker.addOnItemChangedListener(this);


        return view;
    }


    @Override
    public void onCurrentItemChanged(@Nullable MatchesCoursesAdapter.ViewHolder viewHolder, int adapterPosition) {


        MyUtilsApp.showLog(TAG, "ItemChanged adapterposition: " + adapterPosition);

    }

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