package com.example.cenk.derstakip.Utils;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Cenk Faruk Cavga on 21.01.2018.
 */

public class Util {

    /*
      Reads json document from local assests file and returns jason to string.
     */
    public static String getLocalJsonString(String fileName, Context context) {
        String jsonString = null;
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            int size = inputStream.available();
            byte[] bf = new byte[size];
            inputStream.read(bf);
            inputStream.close();
            jsonString = new String(bf, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return jsonString;
    }
}
