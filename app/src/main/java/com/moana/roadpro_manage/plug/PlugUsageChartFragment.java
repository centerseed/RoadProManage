package com.moana.roadpro_manage.plug;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.github.mikephil.charting.data.Entry;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.chart.DayAxisValueFormatter;
import com.moana.roadpro_manage.base.chart.LineChartFragment;

import java.util.ArrayList;
import java.util.Calendar;

public class PlugUsageChartFragment extends LineChartFragment {

    final CharSequence[] items = { "日", "月", "年" };
    int mSelect = 0;

    public PlugUsageChartFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_line_chart, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_date, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_date:
                showSelectedDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume() {
        super.onResume();
        mChart.getXAxis().setValueFormatter(new DayAxisValueFormatter(mChart));

        addLineData(getDummyData(12, 100), "充電站Ａ");

        draw();
    }

    private ArrayList<Entry> getDummyData(int count, int range) {
        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            int val = (int) (Math.random() * range);
            values.add(new Entry(i, val));
        }
        return values;
    }

    private void showSelectedDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("選擇日期區間");

        builder.setSingleChoiceItems(items, mSelect,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        mSelect = item;
                        dialog.dismiss();
                    }
                });
        Dialog levelDialog = builder.create();
        levelDialog.show();
    }
}
