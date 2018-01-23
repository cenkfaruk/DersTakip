package com.example.cenk.derstakip;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.cenk.derstakip.Objects.Lesson;

public class LessonDetail extends AppCompatActivity {

    private WebView lessonWebView;
    private ProgressDialog loadProgress;
    private Lesson lesson;
    private String googleViewer= "http://drive.google.com/viewerng/viewer?embedded=true&url=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_detail);
        init();
    }



    private void init() {
        initLesson();
        lessonWebView = (WebView) findViewById(R.id.lesson_webview);
        lessonWebView.getSettings().setJavaScriptEnabled(true);
        loadProgress = new ProgressDialog(this);
        loadProgress.setMessage("Yükleniyor...");
        loadProgress.setTitle(lesson.getRecentTopic().getName()+"...");
        loadProgress.setIndeterminate(false);
        loadProgress.setCancelable(false);

        lessonWebView.loadUrl(googleViewer+lesson.getRecentTopic().getTopicUrl());

        lessonWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap icon) {
                super.onPageStarted(view, url, icon);
                loadProgress.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                loadProgress.dismiss();
            }
        });
    }

    private void initLesson(){
        lesson=getIntent().getExtras().getParcelable("lesson");
    }
}
