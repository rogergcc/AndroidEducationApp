/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.appsnipp.education.ui.adapter.MatchesCoursesAdapter;
import com.appsnipp.education.ui.helpers.DiscreteScrollViewOptions;
import com.appsnipp.education.ui.listeners.MatchCourseClickListener;
import com.appsnipp.education.ui.model.MatchCourse;
import com.appsnipp.education.ui.model.MyMatchesCourses;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.List;

public class MatchesCoursesActivity extends AppCompatActivity
        implements DiscreteScrollView.OnItemChangedListener<MatchesCoursesAdapter.ViewHolder>,
        View.OnClickListener
        , MatchCourseClickListener {

    private List<MatchCourse> data;
    private MyMatchesCourses myMatchesCourses;


    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter<?> infiniteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches_courses);


        myMatchesCourses = MyMatchesCourses.get();
        data = myMatchesCourses.getData();
        itemPicker = findViewById(R.id.item_picker);
        itemPicker.setOrientation(DSVOrientation.HORIZONTAL);
        itemPicker.addOnItemChangedListener(this);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new MatchesCoursesAdapter(data, this));
        itemPicker.setAdapter(infiniteAdapter);
        itemPicker.setItemTransitionTimeMillis(DiscreteScrollViewOptions.getTransitionTime());
        itemPicker.setItemTransformer(new ScaleTransformer.Builder()
                .setMinScale(0.8f)
                .build());
        itemPicker.setOnClickListener(this);
//        onItemChanged(data.get(0));


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.item_picker:
                int realPosition = infiniteAdapter.getRealPosition(itemPicker.getCurrentItem());
                MatchCourse current = data.get(realPosition);
                Toast.makeText(this, "Data " + current.getName(), Toast.LENGTH_SHORT).show();
                //changeRateButtonState(current);
                break;
//            case R.id.home:
//                finish();
//                break;
//            case R.id.btn_transition_time:
//                DiscreteScrollViewOptions.configureTransitionTime(itemPicker);
//                break;
//            case R.id.btn_smooth_scroll:
//                DiscreteScrollViewOptions.smoothScrollToUserSelectedPosition(itemPicker, v);
//                break;
//            default:
//                showUnsupportedSnackBar();
//                break;
        }


    }

    @Override
    public void onCurrentItemChanged(@Nullable MatchesCoursesAdapter.ViewHolder viewHolder, int adapterPosition) {

    }

    @Override
    public void onScrollPagerItemClick(MatchCourse courseCard, ImageView imageView) {

    }
}
