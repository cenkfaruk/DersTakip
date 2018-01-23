package com.example.cenk.derstakip.Utils;

import android.content.Context;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by Cenk Faruk Cavga on 21.01.2018.
 */

public class Util {

    public static JSONObject getLocalJson(String fileName, Context context) {
        String jsonString = null;
        JSONObject json=null;
        try {
            InputStream inputStream = context.getAssets().open(fileName+".json");
            int size = inputStream.available();
            byte[] bf = new byte[size];
            inputStream.read(bf);
            inputStream.close();
            jsonString = new String(bf, "UTF-8");
            json =new JSONObject(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public static void showShortToast(Context context, String message){
        Toast.makeText(context,message, Toast.LENGTH_SHORT).show();
    }

    public static Picasso getPiccasso(Context context){
        return Picasso.with(context);
    }
}
