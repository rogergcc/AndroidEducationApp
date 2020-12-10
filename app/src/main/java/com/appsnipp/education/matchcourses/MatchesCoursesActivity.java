/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education.matchcourses;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.appsnipp.education.R;
import com.appsnipp.education.fragments.ItemDataClickListener;
import com.appsnipp.education.helpers.DiscreteScrollViewOptions;
import com.yarolegovich.discretescrollview.DSVOrientation;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.InfiniteScrollAdapter;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.List;

public class MatchesCoursesActivity extends AppCompatActivity
        implements DiscreteScrollView.OnItemChangedListener<ShopAdapter.ViewHolder>,
        View.OnClickListener
        , ItemDataClickListener {

    private List<Item> data;
    private Shop shop;

    private TextView currentItemName;
    private TextView currentItemPrice;
    private ImageView rateItemButton;
    private DiscreteScrollView itemPicker;
    private InfiniteScrollAdapter<?> infiniteAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matches_courses);


        shop = Shop.get();
        data = shop.getData();
        itemPicker = findViewById(R.id.item_picker);
        itemPicker.setOrientation(DSVOrientation.HORIZONTAL);
        itemPicker.addOnItemChangedListener(this);
        infiniteAdapter = InfiniteScrollAdapter.wrap(new ShopAdapter(data, this));
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
                Item current = data.get(realPosition);
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
    public void onCurrentItemChanged(@Nullable ShopAdapter.ViewHolder viewHolder, int adapterPosition) {

    }

    @Override
    public void onScrollPagerItemClick(Item courseCard, ImageView imageView) {

    }
}
