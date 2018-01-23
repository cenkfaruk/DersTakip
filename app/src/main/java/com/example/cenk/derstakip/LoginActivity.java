package com.example.cenk.derstakip;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.cenk.derstakip.Objects.Lesson;
import com.example.cenk.derstakip.Objects.Student;
import com.example.cenk.derstakip.Utils.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    private Button login;
    private EditText tckn, password;
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        getStudents();
    }

    private void initViews() {
        login = (Button) findViewById(R.id.login_button);
        tckn = (EditText) findViewById(R.id.tckn);
        password = (EditText) findViewById(R.id.password);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tc=tckn.getText().toString();
                String pass=password.getText().toString();
                if(tc!=null)
                    if(pass!=null)
                        new LoginTask(tc,pass,LoginActivity.this).execute();
                    else
                        Util.showShortToast(LoginActivity.this,"Lütfen şifre giriniz.");
                else
                    Util.showShortToast(LoginActivity.this,"TC kimlik numaranızı Giriniz");
            }
        });
    }


    public class LoginTask extends AsyncTask<Void, Void, Void> {
        ProgressDialog loginProgress;
        String tcNumber;
        String password;
        Context context;
        boolean isStudent = false;

        public LoginTask(String tcNumber, String password, Context context) {
            this.tcNumber = tcNumber;
            this.password = password;
            this.context = context;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loginProgress = new ProgressDialog(context);
            loginProgress.setMessage("Giriş Yapılıyor...");
            //loginProgress.setTitle("");
            loginProgress.setIndeterminate(false);
            loginProgress.setCancelable(false);
            loginProgress.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            isStudent = isStudent(tcNumber, password);
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            loginProgress.dismiss();
            if (isStudent) {
                passToLessons(context);
            }
            else
                Util.showShortToast(context,"TC Kimlik No veya şifre hatalı");


        }
    }


    private void getStudents() {
        JSONArray studentArray = null;
        Gson gson = new Gson();
        Type studentType = new TypeToken<ArrayList<Student>>() {
        }.getType();
        JSONObject object = Util.getLocalJson("students", LoginActivity.this);
        try {
            studentArray = object.getJSONArray("students");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        students = gson.fromJson(studentArray.toString(), studentType);
    }

    private boolean isStudent(String tckn, String password) {
        boolean isStudent = false;
        for (Student std : students) {
            if (std.getTckn().equals(tckn) && std.getPassword().equals(password))
                isStudent = true;
        }
        return isStudent;
    }

    private void passToLessons(Context context){
        Intent intent= new Intent(context,MainActivity.class);
        startActivity(intent);
    }
}


