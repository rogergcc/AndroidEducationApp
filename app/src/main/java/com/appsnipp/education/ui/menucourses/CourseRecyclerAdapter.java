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
import com.appsnipp.education.ui.listeners.CoursesItemClickListener;
import com.appsnipp.education.ui.model.CourseCard;

import java.util.List;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter.ViewHolder> {

    Context mContext;
    private final List<CourseCard> mData;
    private final CoursesItemClickListener coursesItemClickListener;

    public CourseRecyclerAdapter(Context mContext, List<CourseCard> mData, CoursesItemClickListener listener) {
        this.mContext = mContext;
        this.mData = mData;
        this.coursesItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        ItemCardBinding itemCardBinding = ItemCardBinding.inflate(layoutInflater, viewGroup, false);
        return new ViewHolder(itemCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, int position) {
//        viewHolder.mItem = mData.get(position);
        final int pos = viewHolder.getAdapterPosition();
        //Set ViewTag
        viewHolder.itemView.setTag(pos);

        viewHolder.setBind(mData.get(position));

        //2nd intent card only bottom margin in xml  and only top margin in adapter- it works

        viewHolder.itemView.setOnClickListener(v -> coursesItemClickListener.onDashboardCourseClick(mData.get(position), viewHolder.itemCardBinding.cardViewImage));
    }

    public int getDimensionValuePixels(int dimension) {
        return (int) mContext.getResources().getDimension(dimension);
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

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ItemCardBinding itemCardBinding;

        public ViewHolder(@NonNull ItemCardBinding cardBinding) {
            super(cardBinding.getRoot());
            this.itemCardBinding = cardBinding;

            //this.itemRecyclerMealBinding.
        }

        void setBind(CourseCard courseCard) {

            this.itemCardBinding.cardViewImage.setImageResource(courseCard.getImageCourse());

            this.itemCardBinding.stagItemCourse.setText(courseCard.getCourseTitle());
            this.itemCardBinding.stagItemQuantityCourse.setText(courseCard.getQuantityCourses());
            this.itemCardBinding.cardViewImage.setBackgroundColor(itemView.getContext().getResources().getColor(R.color.color1));
        }

    }
}
