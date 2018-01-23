package com.example.cenk.derstakip;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.cenk.derstakip.Adapters.LessonAdapter;
import com.example.cenk.derstakip.Objects.Lesson;
import com.example.cenk.derstakip.Utils.Util;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Lesson> lessons;
    private RecyclerView lessonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        getLessons();
        initView();
    }

    private void findViews(){
        lessonList=(RecyclerView)findViewById(R.id.lessons_list);
        lessonList.setLayoutManager(new LinearLayoutManager(this));
    }
    private void initView(){
        if(lessons!=null &&lessons.size()>0)
            lessonList.setAdapter(new LessonAdapter(MainActivity.this,lessons));
    }

    private void getLessons(){
        JSONArray lessonArray=null;
        Gson gson= new Gson();
        Type lessonType = new TypeToken<ArrayList<Lesson>>(){}.getType();
        JSONObject object= Util.getLocalJson("lessons",MainActivity.this);
        try {
            lessonArray = object.getJSONArray("lessons");
        }
        catch (JSONException e){
            e.printStackTrace();
        }
        lessons= gson.fromJson(lessonArray.toString(),lessonType);
    }
}
