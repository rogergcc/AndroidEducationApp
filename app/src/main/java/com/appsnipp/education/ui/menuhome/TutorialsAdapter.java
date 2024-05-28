/*
 * Copyright (c) 2023. rogergcc
 */

package com.appsnipp.education.ui.menuhome;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.education.databinding.ItemTutorialBinding;
import com.appsnipp.education.ui.model.CourseCard;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Created on diciembre.
 * year 2023 .
 */
public class TutorialsAdapter extends RecyclerView.Adapter<TutorialsAdapter.ViewHolder> {

    private static ClickListener mClickListener;
    private List<CourseCard> mCoursesList;

    public TutorialsAdapter(ClickListener clickListener) {
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
        ItemTutorialBinding binding = ItemTutorialBinding.inflate(inflater, viewGroup, false);
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
        private final ItemTutorialBinding binding;

        public ViewHolder(ItemTutorialBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(@NonNull CourseCard data) {
            Glide.with(itemView.getContext())
//            Glide.with(itemListaInicioBinding.getRoot())
                    .load(data.getImageCourse())
                    .apply(new RequestOptions().centerCrop())
                    .into(binding.imvTutorialPlay);
            binding.txtTitleTutorial.setText(data.getCourseTitle());
            binding.getRoot().setOnClickListener(v -> mClickListener.onClick(data, getLayoutPosition())
            );
        }

    }

}