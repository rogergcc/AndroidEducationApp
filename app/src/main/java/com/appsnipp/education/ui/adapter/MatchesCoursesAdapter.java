/*
 * Copyright (c) 2020. rogergcc
 */

package com.appsnipp.education.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.education.databinding.ItemShopCardBinding;
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
//        View v = inflater.inflate(R.layout.item_shop_card, parent, false);
//        return new ViewHolder(v);

        ItemShopCardBinding itemCardBinding = ItemShopCardBinding.inflate(inflater,parent,false);
        return new MatchesCoursesAdapter.ViewHolder(itemCardBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
//        MatchCourse matchCourseDatos = mData.get(position);
//        Glide.with(holder.itemView.getContext())
//                .load(matchCourseDatos.getImageResource())
////                .transform(new CenterCrop(), new RoundedCorners(24))
////                .transform(new RoundedCorners(40))
//                .into(holder.itemCardBinding.image);

        holder.setBind(mData.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchCourseClickListener.onScrollPagerItemClick(mData.get(position), holder.itemCardBinding.image);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

//        private ImageView image;
//        private TextView tv_titulo;
//        private TextView tv_cantidad_cursos;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            image = itemView.findViewById(R.id.image);
//            tv_titulo = itemView.findViewById(R.id.tv_titulo);
//            tv_cantidad_cursos = itemView.findViewById(R.id.tv_cantidad_cursos);
//        }

        ItemShopCardBinding itemCardBinding;
        public ViewHolder(@NonNull ItemShopCardBinding cardBinding) {
            super(cardBinding.getRoot());
            this.itemCardBinding = cardBinding;

            //this.itemRecyclerMealBinding.
        }

        void setBind(MatchCourse matchCourse){

            itemCardBinding.tvTitulo.setText(matchCourse.getName());
            itemCardBinding.tvCantidadCursos.setText(matchCourse.getNumberOfCourses());

            Glide.with(itemView.getContext())
                    .load(matchCourse.getImageResource())
//                .transform(new CenterCrop(), new RoundedCorners(24))
//                .transform(new RoundedCorners(40))
                    .into(itemCardBinding.image);
        }
    }

}
