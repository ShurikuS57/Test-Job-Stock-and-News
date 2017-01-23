package com.taptm.shurikus.stockandnews.data.source.local;


import android.content.Context;
import android.content.SharedPreferences;

import com.taptm.shurikus.stockandnews.BuildConfig;
import com.taptm.shurikus.stockandnews.R;

public class SettingHelper {

    private static final String PREFERENCES_NAME = BuildConfig.APPLICATION_ID+"_preferences";

    public static String getToken(Context context){
        return getPreferences(context).getString(context.getString(R.string.pref_key_token),"");
    }

    public static void saveToken(Context context, String token){
        getEditor(context).putString(context.getString(R.string.pref_key_token), token).commit();
    }

    private static SharedPreferences getPreferences(Context context){
        return context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    private static SharedPreferences.Editor getEditor(Context context){
        SharedPreferences settings = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
        return settings.edit();
    }

}
