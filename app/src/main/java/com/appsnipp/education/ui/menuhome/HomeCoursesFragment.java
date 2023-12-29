/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education.ui.menuhome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.appsnipp.education.R;
import com.appsnipp.education.databinding.FragmentHomeCoursesBinding;
import com.appsnipp.education.ui.model.CourseCard;

import java.util.ArrayList;
import java.util.List;

public class HomeCoursesFragment extends Fragment implements PopularCoursesAdapter.ClickListener {

    FragmentHomeCoursesBinding binding;

    private static final String TAG = "HomeCoursesFragment";

    public HomeCoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void setUpUI() {
        String percentage = getResources().getString(R.string.percentage_course, 75);
        binding.tvPercentage.setText(percentage);

        LinearLayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.rvPopularCourses.setLayoutManager(layoutManager);
        binding.rvPopularCourses.hasFixedSize();

        PopularCoursesAdapter popularCoursesAdapter = new PopularCoursesAdapter(this);
        binding.rvPopularCourses.setAdapter(popularCoursesAdapter);

        List<CourseCard> courseCardsList = new ArrayList<>();
        courseCardsList.add(new CourseCard(1, R.drawable.education_1, "Desing Thinking", "19 courses"));
        courseCardsList.add(new CourseCard(2, R.drawable.education_2, "Software Development", "14 courses"));
        courseCardsList.add(new CourseCard(3, R.drawable.education_5, "Marketing", "24 courses"));
        courseCardsList.add(new CourseCard(4, R.drawable.education_4, "Security Expert", "18 courses"));

        popularCoursesAdapter.setListDataItems(courseCardsList);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeCoursesBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        setUpUI();
        return view;
    }

    @Override
    public void onClick(CourseCard view, int position) {

    }
}