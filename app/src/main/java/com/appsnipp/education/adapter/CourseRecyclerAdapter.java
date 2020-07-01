/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education.adapter;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsnipp.education.R;
import com.appsnipp.education.model.CourseCard;

import java.util.List;

public class CourseRecyclerAdapter extends RecyclerView.Adapter<CourseRecyclerAdapter._ViewHolder> {

    Context mContext;
    private List<CourseCard> mData;
    private CoursesItemClickListener coursesItemClickListener;

    public CourseRecyclerAdapter(Context mContext, List<CourseCard> mData, CoursesItemClickListener listener) {
        this.mContext = mContext;
        this.mData = mData;
        this.coursesItemClickListener = listener;
    }

    @NonNull
    @Override
    public CourseRecyclerAdapter._ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_card,viewGroup,false);
        return new _ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CourseRecyclerAdapter._ViewHolder viewHolder, final int i) {
        viewHolder.mItem = mData.get(i);
        final int pos = viewHolder.getAdapterPosition();
        //Set ViewTag
        viewHolder.itemView.setTag(pos);

        viewHolder.setPostImage(mData.get(i));
        viewHolder.course.setText(mData.get(i).getCourseTitle());
        viewHolder.quantity_courses.setText(mData.get(i).getQuantityCourses());

        //1st intent 2 methods
//        if (i%2==1){
//            ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) viewHolder.card_item.getLayoutParams();
//            cardViewMarginParams.setMargins(dpToPx(8), dpToPx(16), 0, 0);
//            viewHolder.card_item.requestLayout();
//        }
//        if (i==1){
//            ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) viewHolder.card_item.getLayoutParams();
//            cardViewMarginParams.setMargins(dpToPx(8), dpToPx(32), 0, 0);
//            viewHolder.card_item.requestLayout();
//        }

        //2nd intent card only bottom margin in xml  and only top margin in adapter- it works
        if (i%2==1){

            int dimenTopPixeles = getDimensionValuePixels(R.dimen.staggedmarginbottom);
            int dimenleftPixeles = getDimensionValuePixels(R.dimen.horizontal_card);
            ViewGroup.MarginLayoutParams cardViewMarginParams = (ViewGroup.MarginLayoutParams) viewHolder.card_item.getLayoutParams();
//            cardViewMarginParams.setMargins(dpToPx(8), dpToPx(20), 0, 0);
            cardViewMarginParams.setMargins(dimenleftPixeles, dimenTopPixeles, 0, 0);
            viewHolder.card_item.requestLayout();
        }

//      viewHolder.card_item.setBackgroundColor(mContext.getResources().getColor(R.color.color1));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coursesItemClickListener.onDashboardCourseClick(mData.get(i), viewHolder.imageView);
            }
        });
    }

    public int getDimensionValuePixels(int dimension)
    {
        return (int) mContext.getResources().getDimension(dimension);
    }


    public int dpToPx(int dp)
    {
        float scale = mContext.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
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

    public class _ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView course;
        TextView quantity_courses;
        CardView card_item;
        public CourseCard mItem;
        public _ViewHolder(@NonNull View itemView) {
            super(itemView);
            card_item = itemView.findViewById(R.id.card_item);
            imageView = itemView.findViewById(R.id.card_view_image);
            course = itemView.findViewById(R.id.stag_item_course);
            quantity_courses = itemView.findViewById(R.id.stag_item_quantity_course);
        }

        void setPostImage(CourseCard courseCard){
            imageView.setImageResource(courseCard.getImageCourse());
        }
    }
}
