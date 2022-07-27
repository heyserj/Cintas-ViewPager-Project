package com.example.viewpagerproject;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.SplittableRandom;

public class MyPreference {

    public static final String myPrefs = "MyPrefs";
    public static final String username = "user";
    public static final String password = "pass";
    SharedPreferences preference;

    public static void setUsername(Context context, String name){
        SharedPreferences preference = context.getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preference.edit();
        editor.putString(username, name);
        editor.commit();
    }

    public static String getUsername(Context context){
        SharedPreferences preference = context.getSharedPreferences(myPrefs, Context.MODE_PRIVATE);
        return preference.getString(username, "");
    }
}
