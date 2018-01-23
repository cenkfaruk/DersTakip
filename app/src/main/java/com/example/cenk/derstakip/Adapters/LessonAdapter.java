package com.example.cenk.derstakip.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.cenk.derstakip.LessonDetail;
import com.example.cenk.derstakip.Objects.Lesson;
import com.example.cenk.derstakip.R;
import com.example.cenk.derstakip.Utils.Util;

import java.util.ArrayList;

/**
 * Created by Cenk Faruk Cavga on 21.01.2018.
 */

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonPlaceHolder> {
    private Context context;
    private ArrayList<Lesson>lessons;


    public LessonAdapter(Context context, ArrayList<Lesson> lessons){
        this.context=context;
        this.lessons=lessons;
    }

    @Override
    public LessonPlaceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lesson_card, parent, false);

        return new LessonPlaceHolder(itemView);
    }

    @Override
    public void onBindViewHolder(LessonPlaceHolder holder, int position) {
        final Lesson lesson = lessons.get(position);

        holder.lesson.setText(lesson.getName());
        holder.instructorName.setText(lesson.getInstructor().getName()+" "+lesson.getInstructor().getSurname());
        Util.getPiccasso(context).load(lesson.getInstructor().getPhoto()).into(holder.instructorPhoto);
        holder.lessonDesc.setText(lesson.getRecentTopic().getDescription());
        holder.lessonProgress.setMax(100);
        holder.lessonProgress.setProgress(lesson.getProgress());
        holder.topic.setText(lesson.getRecentTopic().getName());

        SpannableString span = new SpannableString(lesson.getRecentPages());
        span.setSpan(new UnderlineSpan(), 0, lesson.getRecentPages().length(), 0);
        holder.recentPages.setText(span);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passToLessonDetail(lesson);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public static class LessonPlaceHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView lesson,instructorName,lessonDesc,recentPages,topic;
        ImageView instructorPhoto;
        ProgressBar lessonProgress;

        public LessonPlaceHolder(View view){
            super(view);
            cardView = (CardView) view.findViewById(R.id.lesson_cardview);
            lesson = (TextView) view.findViewById(R.id.lesson_name);
            instructorName = (TextView) view.findViewById(R.id.instructor_name);
            lessonDesc = (TextView) view.findViewById(R.id.lesson_topic_desc);
            recentPages = (TextView) view.findViewById(R.id.recent_pages);
            topic = (TextView) view.findViewById(R.id.lesson_topic);
            instructorPhoto = (ImageView) view.findViewById(R.id.instructor_photo);
            lessonProgress = (ProgressBar) view.findViewById(R.id.lesson_progress);
        }
    }

    private void passToLessonDetail(Lesson lesson){
        if(lesson!=null) {
            Intent intent = new Intent(context, LessonDetail.class);
            intent.putExtra("lesson", lesson);
            context.startActivity(intent);
        }
    }
}
