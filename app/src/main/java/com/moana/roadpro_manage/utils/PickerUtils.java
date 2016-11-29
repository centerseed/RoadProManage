package com.moana.roadpro_manage.utils;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.widget.DatePicker;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.MonthYearPickerDialog;

import java.util.Calendar;

import biz.kasual.materialnumberpicker.MaterialNumberPicker;

public class PickerUtils {

    public interface YearPickerListener {
        void onYearSelected(int year);
    }

    public static void showYearPicker(Context context, final YearPickerListener listener) {
        MaterialNumberPicker numberPicker = new MaterialNumberPicker.Builder(context)
                .minValue(2016)
                .maxValue(Calendar.getInstance().get(Calendar.YEAR) + 2)
                .defaultValue(Calendar.getInstance().get(Calendar.YEAR))
                .backgroundColor(Color.WHITE)
                .separatorColor(context.getResources().getColor(R.color.colorAccent))
                .textColor(Color.BLACK)
                .textSize(20)
                .enableFocusability(false)
                .wrapSelectorWheel(true)
                .build();

        new AlertDialog.Builder(context)
                .setTitle("請選擇年份")
                .setView(numberPicker)
                .setPositiveButton(context.getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (listener != null) {
                            listener.onYearSelected(which);
                        }
                    }
                })
                .show();
    }

    public static void showMonthPicker(android.support.v4.app.FragmentManager manager, DatePickerDialog.OnDateSetListener listener) {
        MonthYearPickerDialog dialog = new MonthYearPickerDialog();
        dialog.setListener(listener);
        dialog.show(manager, "");
    }

    public static void showDatePicker(Context context, DatePickerDialog.OnDateSetListener listener) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, listener, year, month, day);
        datePickerDialog.show();
    }
}
