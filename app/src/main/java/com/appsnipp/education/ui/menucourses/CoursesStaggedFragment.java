/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education.ui.menucourses;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.appsnipp.education.R;
import com.appsnipp.education.data.CourseCardsFake;
import com.appsnipp.education.databinding.FragmentCoursesStaggedBinding;
import com.appsnipp.education.ui.listeners.ItemClickListener;
import com.appsnipp.education.ui.model.CourseCard;
import com.appsnipp.education.ui.utils.MyUtilsApp;
import com.appsnipp.education.ui.utils.helpers.GridSpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;


public class CoursesStaggedFragment extends Fragment
        implements ItemClickListener<CourseCard> {

    FragmentCoursesStaggedBinding binding;
    private Context mcontext;

    public CoursesStaggedFragment() {
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
//        return inflater.inflate(R.layout.fragment_courses_stagged, container, false);

        binding = FragmentCoursesStaggedBinding.inflate(getLayoutInflater());
        mcontext = this.getContext();
        View view = binding.getRoot();


        binding.edtSearch.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                //For this example only use seach option
                //U can use a other view with activityresult
                performSearch();
                Toast.makeText(mcontext,
                        "Edt Searching Click: " + binding.edtSearch.getText().toString().trim(),
                        Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });

        StaggeredGridLayoutManager layoutManager =
                new StaggeredGridLayoutManager(
                        2,
                        StaggeredGridLayoutManager.VERTICAL);

        binding.rvCourses.setLayoutManager(
                layoutManager
        );
        binding.rvCourses.setClipToPadding(false);
        binding.rvCourses.setHasFixedSize(true);

//        binding.rvCourses.addItemDecoration(
//                new HorizontalMarginItemDecoration(
//                        mcontext,
//                        R.dimen.top_text_subtitle_card,
//                        R.dimen.top_text_subtitle_card
//                )
//        );

        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.horizontal_card);
        binding.rvCourses.addItemDecoration(new GridSpacingItemDecoration(2, spacingInPixels, true, 0));

        List<CourseCard> courseCards = new ArrayList<>();

        courseCards = CourseCardsFake.getInstance().getSearchCoursesCards();
        CourseRecyclerAdapter adapter = new CourseRecyclerAdapter(mcontext, courseCards, this);

//        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.card_margin);
//        binding.rvCourses.addItemDecoration(new SpacesItemDecoration(spacingInPixels));

        binding.rvCourses.setAdapter(adapter);
        return view;
    }

    private void performSearch() {
        binding.edtSearch.clearFocus();
        InputMethodManager in = (InputMethodManager) mcontext.getSystemService(Context.INPUT_METHOD_SERVICE);
        in.hideSoftInputFromWindow(binding.edtSearch.getWindowToken(), 0);
        //...perform search
    }

//    @Override
//    public void onDashboardCourseClick(CourseCard courseCard, ImageView imageView) {
//        Toast.makeText(mcontext, courseCard.getCourseTitle(), Toast.LENGTH_LONG).show();
//    }

    @Override
    public void onItemClick(CourseCard item, ImageView imageView) {
        String quantityCourseMessage = item.getQuantityCourses() + " courses";
        MyUtilsApp.showToast(requireContext(), quantityCourseMessage);

    }
}