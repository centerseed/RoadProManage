package com.moana.roadpro_manage.utils;

import android.content.Context;
import android.preference.PreferenceManager;

import com.moana.roadpro_manage.base.ConstantDef;


public class PreferenceUtils {
    public static void setCurrentFunction(Context context, int func) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putInt("function", func).commit();
    }

    public static int getCurrentFunction(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt("function", 0);
    }
}
