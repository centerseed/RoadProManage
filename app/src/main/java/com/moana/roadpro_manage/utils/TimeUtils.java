package com.moana.roadpro_manage.utils;


import android.content.Context;

import com.moana.roadpro_manage.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
    public static String getYYYYMMDDStr(Context context, long timeStamp) {
        try {
            DateFormat sdf = new SimpleDateFormat(context.getResources().getString(R.string.title_time_format));
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        } catch (Exception ex) {
            DateFormat sdf = new SimpleDateFormat(context.getResources().getString(R.string.title_time_format_no_hour));
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        }
    }

    public static long getYYYYMMDDTimeStamp(Context context, String time) {
        try {
            DateFormat sdf = new SimpleDateFormat(context.getResources().getString(R.string.title_time_format));
            Date netDate = sdf.parse(time);
            return netDate.getTime();
        } catch (Exception ex) {
            return 0;
        }
    }

    public static String getMMDD(Context context, long timeStamp) {
        try {
            DateFormat sdf = new SimpleDateFormat(context.getResources().getString(R.string.title_time_mmdd));
            Date netDate = (new Date(timeStamp));
            return sdf.format(netDate);
        } catch (Exception ex) {
            return "";
        }
    }
}
