package com.taptm.shurikus.stockandnews.utils;


import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;

import com.taptm.shurikus.stockandnews.R;
import com.taptm.shurikus.stockandnews.data.post.ContentPost;
import com.taptm.shurikus.stockandnews.data.post.TokenPost;

public class PostHelper {

    private static final String APP_VERSION_TOKEN = "1.1.0";
    private static final String APP_VERSION_CONTENT = "1.2.0";
    private static final String LATITUDE = "0";
    private static final String LONGITUDE = "0";
    private static final String DEVICE_TYPE = "0";
    private static final int MAX_POST = 100;

    public static TokenPost calcTokenPost(Context context, TokenPost tokenPost){
        int screenHeight = context.getResources().getDisplayMetrics().heightPixels;
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;

        tokenPost.setApp_key(context.getString(R.string.API_KEY));
        tokenPost.setPackage_name(context.getString(R.string.PACKEGE_NAME));
        tokenPost.setApp_version(APP_VERSION_TOKEN);
        tokenPost.setLatitude(LATITUDE);
        tokenPost.setLongitude(LONGITUDE);
        tokenPost.setDevicetype(DEVICE_TYPE);
        tokenPost.setDeviceversion(String.valueOf(Build.VERSION.SDK_INT));
        tokenPost.setDevicemodel(getDeviceName());
        tokenPost.setScreenwidth(String.valueOf(screenWidth));
        tokenPost.setScreenheight(String.valueOf(screenHeight));

        tokenPost.setAiuid(getAiuid(context));
        return tokenPost;
    }

    public static ContentPost calcContentPost(Context context, ContentPost contentPost){
        int screenHeight = context.getResources().getDisplayMetrics().heightPixels;
        int screenWidth = context.getResources().getDisplayMetrics().widthPixels;

        contentPost.setApp_key(context.getString(R.string.API_KEY));
        contentPost.setPackage_name(context.getString(R.string.PACKEGE_NAME));
        contentPost.setApp_version(APP_VERSION_CONTENT);
        contentPost.setLatitude(LATITUDE);
        contentPost.setLongitude(LONGITUDE);
        contentPost.setDevicetype(DEVICE_TYPE);
        contentPost.setDeviceversion(String.valueOf(Build.VERSION.SDK_INT));
        contentPost.setDevicemodel(getDeviceName());
        contentPost.setScreenwidth(String.valueOf(screenWidth));
        contentPost.setScreenheight(String.valueOf(screenHeight));

        contentPost.setLast_session_datetime(0);
        contentPost.setContent_type_id(0);
        contentPost.setFrom_id(0);
        contentPost.setMax(MAX_POST);

        return contentPost;
    }

    private static String getAiuid(Context context){
        String android_id = Settings.Secure.getString(context.getContentResolver(),
                Settings.Secure.ANDROID_ID);
        if(android_id != null) {
            return android_id;
        }
        return "0";
    }


    private static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        }
        return capitalize(manufacturer) + " " + model;
    }

    private static String capitalize(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] arr = str.toCharArray();
        boolean capitalizeNext = true;

        StringBuilder phrase = new StringBuilder();
        for (char c : arr) {
            if (capitalizeNext && Character.isLetter(c)) {
                phrase.append(Character.toUpperCase(c));
                capitalizeNext = false;
                continue;
            } else if (Character.isWhitespace(c)) {
                capitalizeNext = true;
            }
            phrase.append(c);
        }
        return phrase.toString();
    }
}
