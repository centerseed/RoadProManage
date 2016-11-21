package com.moana.roadpro_manage.base.chart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.moana.roadpro_manage.R;

import java.util.ArrayList;

public class StackBarChartFragment extends BarChartFragment {

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mChart.getAxisRight().setEnabled(false);
        mChart.getXAxis().setValueFormatter(new DayAxisValueFormatter(mChart));
        mChart.getXAxis().setGranularity(1f);

        Legend l = mChart.getLegend();
        l.setEnabled(true);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setFormSize(12f);
        l.setFormToTextSpace(6f);
        l.setXEntrySpace(16f);
        l.setTextSize(16f);
    }

    @Override
    protected void addBarData(ArrayList<BarEntry> values) {
        BarDataSet barDataSet = new BarDataSet(values, " 週轉率");
        barDataSet.setColors(ColorArray);
        barDataSet.setDrawValues(false);
        barDataSet.setStackLabels(new String[]{"日", "月"});

        mDataSet.clear();
        mDataSet.add(barDataSet);
        mChart.setFitBars(true);
    }
}
