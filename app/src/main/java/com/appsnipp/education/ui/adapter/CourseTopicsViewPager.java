package com.appsnipp.education.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.appsnipp.education.databinding.ItemPagerCardBinding;
import com.appsnipp.education.ui.listeners.MatchCourseClickListener;
import com.appsnipp.education.ui.model.MatchCourse;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import java.util.List;


public class CourseTopicsViewPager extends RecyclerView.Adapter<CourseTopicsViewPager.ViewHolder> {
    private LayoutInflater mInflater;
    private List<MatchCourse> mCoursesList;
    private Context mContext;
    private MatchCourseClickListener matchCourseClickListener;

    public CourseTopicsViewPager(List<MatchCourse> mCoursesList, Context context, MatchCourseClickListener listener) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.mCoursesList = mCoursesList;
        this.matchCourseClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = mInflater.inflate(R.layout.item_pager_card, parent, false);
//        return new ViewHolder(view);
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View v = inflater.inflate(R.layout.item_shop_card, parent, false);
//        return new ViewHolder(v);

        ItemPagerCardBinding itemPagerCardBinding = ItemPagerCardBinding.inflate(inflater, parent, false);
        return new ViewHolder(itemPagerCardBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setBind(mCoursesList.get(position));

        holder.binding.cardViewCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                matchCourseClickListener.onScrollPagerItemClick(mCoursesList.get(position), holder.binding.image);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCoursesList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {


        ItemPagerCardBinding binding;

        ViewHolder(@NonNull ItemPagerCardBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void setBind(MatchCourse matchCourse) {

            binding.tvTitulo.setText(matchCourse.getName());
            binding.tvCantidadCursos.setText(matchCourse.getNumberOfCourses());

            Glide.with(itemView.getContext())
                    .load(matchCourse.getImageResource())
//                .transform(new CenterCrop(), new RoundedCorners(24))
//                .transform(new RoundedCorners(40))
                    .transform(new CenterCrop())
                    .into(binding.image);
        }


    }
}
