package com.example.cenk.derstakip.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cenk.derstakip.R;

/**
 * Created by Cenk Faruk Cavga on 21.01.2018.
 */

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonPlaceHolder> {


    @Override
    public LessonPlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(LessonPlaceHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class LessonPlaceHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView lesson;
        TextView instructorName;
        TextView lessonDesc;
        ImageView instructorPhoto;
        ProgressBar lessonProgress;

        public LessonPlaceHolder(View view){
            super(view);
            cardView = (CardView) view.findViewById(R.id.lesson_cardview);
            lesson = (TextView) view.findViewById(R.id.lesson_name);
            instructorName = (TextView) view.findViewById(R.id.instructor_name);
            lessonDesc = (TextView) view.findViewById(R.id.lesson_topic_desc);
            instructorPhoto = (ImageView) view.findViewById(R.id.instructor_photo);
            lessonProgress = (ProgressBar) view.findViewById(R.id.lesson_progress);
        }
    }
}
