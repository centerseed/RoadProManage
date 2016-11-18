package com.moana.roadpro_manage.base.chart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.moana.roadpro_manage.R;

import java.util.ArrayList;

public abstract class PieChartFragment extends Fragment {

    PieChart mChart;
    PieDataSet dataSet;
    int ColorArray[];

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ColorArray = new int[]{getResources().getColor(R.color.colorLine1),
                getResources().getColor(R.color.colorLine2),
                getResources().getColor(R.color.colorLine3),
                getResources().getColor(R.color.colorLine4)};
        initChart(view);
    }

    private void initChart(View view) {
        mChart = (PieChart) view.findViewById(R.id.pie_chart);
        mChart.setUsePercentValues(true);
        mChart.getDescription().setEnabled(false);

        mChart.setTransparentCircleColor(Color.WHITE);
        mChart.setTransparentCircleAlpha(110);
        mChart.setHighlightPerTapEnabled(true);
        mChart.animateY(1400, Easing.EasingOption.EaseInOutQuad);

        // entry label styling
        mChart.setDrawEntryLabels(false);
        mChart.setEntryLabelColor(Color.TRANSPARENT);
        mChart.setEntryLabelTextSize(0f);
        mChart.setRotationAngle(310);
        mChart.setHoleColor(Color.TRANSPARENT);
        mChart.setHoleRadius(90f);

        Legend l = mChart.getLegend();
        l.setEnabled(false);
    }

    protected abstract PieDataSet getDataSet();

    protected void draw() {
        dataSet = getDataSet();
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setDrawValues(false);

        ArrayList<Integer> colors = new ArrayList<Integer>();
        for (int i = 0; i < ColorArray.length; i++) {
            colors.add(ColorArray[i]);
        }
        dataSet.setColor(getResources().getColor(R.color.colorYellow));

        PieData pieData = new PieData(dataSet);
        mChart.setData(pieData);
        mChart.invalidate();
    }
}
