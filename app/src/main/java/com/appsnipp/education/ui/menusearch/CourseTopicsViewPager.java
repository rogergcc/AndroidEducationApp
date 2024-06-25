/*
 * Copyright (c) 2021. rogergcc
 */

package com.appsnipp.education.ui.menusearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.education.databinding.ItemPagerCardBinding;
import com.appsnipp.education.ui.base.BaseViewHolder;
import com.appsnipp.education.ui.listeners.ItemClickListener;
import com.appsnipp.education.ui.model.MatchCourse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import java.util.List;


public class CourseTopicsViewPager
        extends RecyclerView.Adapter<BaseViewHolder<MatchCourse>> {
    private final List<MatchCourse> mCoursesList;
    private final ItemClickListener<MatchCourse> matchCourseClickListener;

    public CourseTopicsViewPager(List<MatchCourse> mCoursesList, Context context, ItemClickListener<MatchCourse> listener) {
        this.mCoursesList = mCoursesList;
        this.matchCourseClickListener = listener;
    }

    @NonNull
    @Override
    public BaseViewHolder<MatchCourse> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemPagerCardBinding itemPagerCardBinding = ItemPagerCardBinding.inflate(inflater, parent, false);
        return new ViewHolder(itemPagerCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<MatchCourse> holder, int position) {
        MatchCourse item = mCoursesList.get(position);
        holder.bind(item);
        ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.getItemCardBinding().cardViewCourse.setOnClickListener(v -> {
            matchCourseClickListener.onItemClick(item,
                    viewHolder.getItemCardBinding().image);
        });

//        holder.setBind(mCoursesList.get(position));
//
//        holder.binding.cardViewCourse.setOnClickListener(
//                v -> matchCourseClickListener.onScrollPagerItemClick(
//                        mCoursesList.get(holder.getAdapterPosition()),
//                        holder.binding.image));
    }
    @Override
    public int getItemCount() {
        return mCoursesList.size();
    }


    public static class ViewHolder extends BaseViewHolder<MatchCourse> {

        ItemPagerCardBinding itemCardBinding;

        public ViewHolder(@NonNull ItemPagerCardBinding binding) {
            super(binding.getRoot());
            this.itemCardBinding = binding;
        }

        public ItemPagerCardBinding getItemCardBinding() {
            return itemCardBinding;
        }

        @Override
        public void bind(MatchCourse matchCourse) {
            itemCardBinding.tvTitulo.setText(matchCourse.getName());
            itemCardBinding.tvCantidadCursos.setText(matchCourse.getNumberOfCourses());

            Glide.with(itemView.getContext())
                    .load(matchCourse.getImageResource())
                    .transform(new CenterCrop())
                    .into(itemCardBinding.image);
        }
    }
}
