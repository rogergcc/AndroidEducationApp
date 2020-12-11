/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.education.R;
import com.appsnipp.education.ui.listeners.MatchCourseClickListener;
import com.appsnipp.education.ui.model.MatchCourse;
import com.bumptech.glide.Glide;

import java.util.List;


public class MatchesCoursesAdapter extends RecyclerView.Adapter<MatchesCoursesAdapter.ViewHolder> {

    private List<MatchCourse> mData;
    private MatchCourseClickListener matchCourseClickListener;
    public MatchesCoursesAdapter(List<MatchCourse> mData, MatchCourseClickListener listener) {
        this.mData = mData;
        this.matchCourseClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_shop_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MatchCourse matchCourseDatos = mData.get(position);

        holder.tv_titulo.setText(matchCourseDatos.getName());
        holder.tv_cantidad_cursos.setText(matchCourseDatos.getNumberOfCourses());

        Glide.with(holder.itemView.getContext())
                .load(matchCourseDatos.getImageResource())
//                .transform(new CenterCrop(), new RoundedCorners(24))
//                .transform(new RoundedCorners(40))
                .into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchCourseClickListener.onScrollPagerItemClick(matchCourseDatos, holder.image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView image;
        private TextView tv_titulo;
        private TextView tv_cantidad_cursos;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            tv_titulo = itemView.findViewById(R.id.tv_titulo);
            tv_cantidad_cursos = itemView.findViewById(R.id.tv_cantidad_cursos);
        }
    }
}
