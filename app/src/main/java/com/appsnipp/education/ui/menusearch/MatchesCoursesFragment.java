/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education.ui.menusearch;

import static java.lang.Math.abs;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.appsnipp.education.R;
import com.appsnipp.education.data.CoursesRepository;
import com.appsnipp.education.databinding.FragmentMatchesCoursesBinding;
import com.appsnipp.education.ui.listeners.MatchCourseClickListener;
import com.appsnipp.education.ui.model.MatchCourse;
import com.appsnipp.education.ui.utils.AppLogger;
import com.appsnipp.education.ui.utils.MyUtilsApp;
import com.appsnipp.education.ui.utils.helpers.HorizontalMarginItemDecoration;

import java.util.List;
import java.util.Locale;


public class MatchesCoursesFragment extends Fragment
        implements
//        DiscreteScrollView.OnItemChangedListener<MatchesCoursesAdapter.ViewHolder>
        MatchCourseClickListener {

    private static final String TAG = "MatchesCoursesFragment";
    FragmentMatchesCoursesBinding binding;
    Context mcontext;


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
        binding = FragmentMatchesCoursesBinding.inflate(getLayoutInflater());
        mcontext = this.getContext();
        View view = binding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        MyCoursesViewModel viewModel = new ViewModelProvider(this,
                new MyCoursesViewModelFactory(
                        new CoursesRepository())).get(MyCoursesViewModel.class);

        viewModel.getDataQrListVM();

        viewModel.getLiveDataQrList().observe(getViewLifecycleOwner(), matchCourses -> {
            setupViewpager(1, matchCourses);
        });

    }

    private void setupAdapter(int currentItem, List<MatchCourse> matchCourseList) {
        CourseTopicsViewPager courseTopicsViewPager = new CourseTopicsViewPager(matchCourseList, mcontext, this);
        binding.viewPager.setAdapter(courseTopicsViewPager);
        // set selected item
        binding.viewPager.setCurrentItem(currentItem);
        // You need to retain one page on each side so that the next and previous items are visible
        binding.viewPager.setOffscreenPageLimit(1);
    }


    private void setupPageTransformer() {
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
    }

    private void setupItemDecoration() {
        binding.viewPager
                .addItemDecoration(new HorizontalMarginItemDecoration(
                        mcontext, R.dimen.viewpager_current_item_horizontal_margin_testing,
                        R.dimen.viewpager_next_item_visible_testing)
                );
    }

    private void setupPageChangeCallback(List<MatchCourse> matchCourseList) {
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
//            countTxtView.setText(String.format(Locale.ENGLISH,"%d/%d", position+1, matchCourseList.size()));
//                String positionSelected = String.format(Locale.ENGLISH, "%d/%d", position + 1, matchCourseList.size());
//                AppLogger.d("[" + TAG + "] " + positionSelected);


            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                MyUtilsApp.showToast(mcontext, matchCourseList.get(position).getName());
//                Random rnd = new Random();
//                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                String positionSelected = String.format(Locale.ENGLISH, "%d/%d", position + 1, matchCourseList.size());
                AppLogger.d("[" + TAG + "] " + positionSelected);

                int color = ((int) (Math.random() * 16777215)) | (0xFF << 24);
//                onCourseRated(position,true);

                binding.containerConstraint.setBackgroundColor(color);

            }
        });
    }

    private void setupViewpager(int currentItem, List<MatchCourse> matchCourseList) {
        setupAdapter(currentItem, matchCourseList);


        setupPageTransformer();
        setupItemDecoration();
        setupPageChangeCallback(matchCourseList);


    }


    @Override
    public void onScrollPagerItemClick(MatchCourse courseCard, ImageView imageView) {

        AppLogger.d("[" + TAG + "] onScrollPagerItemClick() " + courseCard);
        //Now, this has dynamic data from myMatchesCourses.getData();.
        //Could use the Id as unique value for go to new activity
//        Intent intentGetStarted;
//        intentGetStarted = new Intent(mcontext, YourActivity.class);
//        startActivity(intentGetStarted);
    }
}