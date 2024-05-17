/*
 * Copyright (c) 2024. rogergcc
 */

package com.appsnipp.education.ui.utils.helpers;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HorizontalMarginItemDecoration extends RecyclerView.ItemDecoration {
    private final int marginLeft;
    private final int mMargin;

    public HorizontalMarginItemDecoration(Context context, @DimenRes int margin, @DimenRes int mleft) {
        mMargin = (int) context.getResources().getDimension(margin);
        marginLeft = (int) context.getResources().getDimension(mleft);
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.right = mMargin;
        outRect.left = marginLeft;
    }
}
