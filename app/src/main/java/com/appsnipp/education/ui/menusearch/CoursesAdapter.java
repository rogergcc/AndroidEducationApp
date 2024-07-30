/*
 * Copyright (c) 2024. rogergcc
 */

package com.appsnipp.education.ui.menusearch;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.education.databinding.ItemPopularCourseBinding;
import com.appsnipp.education.ui.model.CourseCard;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.ViewHolder> {

    private static ClickListener mClickListener;
    private List<CourseCard> mCoursesList;

    public CoursesAdapter(ClickListener clickListener) {
        mClickListener = clickListener;
    }

    public void setListDataItems(List<CourseCard> listItems) {
        this.mCoursesList = listItems;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mCoursesList == null)
            return 0;
        else
            return mCoursesList.size();
    }

    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
//        ItemListaInicioBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_job, parent, false);
        ItemPopularCourseBinding binding = ItemPopularCourseBinding.inflate(inflater, viewGroup, false);
        return new ViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        CourseCard item = mCoursesList.get(i);
        if (item != null) {
            viewHolder.bind(item);
        }
    }

    public interface ClickListener {
        void onClick(CourseCard view, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemPopularCourseBinding binding;

        public ViewHolder(ItemPopularCourseBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(@NonNull CourseCard data) {
//            Glide.with(itemView.getContext())
////            Glide.with(itemListaInicioBinding.getRoot())
//                    .load(data.getImageCourse())
//                    .apply(new RequestOptions().centerCrop())
//                    .into(binding.ivPlayCourse);
            binding.tvTitleCourse.setText(data.getCourseTitle());
            binding.tvDetailsCourse.setText(data.getQuantityCourses());
            binding.getRoot()
                    .setOnClickListener(
                            v -> mClickListener.onClick(data, getLayoutPosition()));
        }

    }

}