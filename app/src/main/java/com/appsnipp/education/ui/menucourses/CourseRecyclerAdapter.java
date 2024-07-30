/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education.ui.menucourses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.education.R;
import com.appsnipp.education.databinding.ItemCardBinding;
import com.appsnipp.education.ui.base.BaseViewHolder;
import com.appsnipp.education.ui.listeners.ItemClickListener;
import com.appsnipp.education.ui.model.CourseCard;

import java.util.List;

public class CourseRecyclerAdapter extends
        RecyclerView.Adapter<BaseViewHolder<CourseCard>> {

    final Context mContext;
    private final List<CourseCard> mData;
    private final ItemClickListener<CourseCard> itemClickListener;

    public CourseRecyclerAdapter(Context mContext, List<CourseCard> mData, ItemClickListener<CourseCard> listener) {
        this.mContext = mContext;
        this.mData = mData;
        this.itemClickListener = listener;
    }


    @NonNull
    @Override
    public BaseViewHolder<CourseCard> onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ItemCardBinding itemCardBinding = ItemCardBinding.inflate(layoutInflater, viewGroup, false);
        return new ViewHolder(itemCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<CourseCard> holder, int position) {
        CourseCard item = mData.get(position);
        holder.bind(item);
        holder.itemView.setOnClickListener(v -> {
            ViewHolder viewHolder = (ViewHolder) holder;
            itemClickListener.onItemClick(item, viewHolder.getItemCardBinding().cardViewImage);
        });
    }



    @Override
    public long getItemId(int position) {
        CourseCard courseCard = mData.get(position);
        return courseCard.getId();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends BaseViewHolder<CourseCard> {

        ItemCardBinding itemCardBinding;

        public ViewHolder(@NonNull ItemCardBinding cardBinding) {
            super(cardBinding.getRoot());
            this.itemCardBinding = cardBinding;
        }

        public ItemCardBinding getItemCardBinding() {
            return itemCardBinding;
        }

        @Override
        public void bind(CourseCard item) {
            this.itemCardBinding.cardViewImage.setImageResource(item.getImageCourse());
            this.itemCardBinding.stagItemCourse.setText(item.getCourseTitle());
            this.itemCardBinding.stagItemQuantityCourse.setText(item.getQuantityCourses());
            this.itemCardBinding.cardViewImage.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.color1));
        }
    }
}
