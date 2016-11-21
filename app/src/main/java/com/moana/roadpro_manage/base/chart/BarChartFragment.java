package com.moana.roadpro_manage.base.chart;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.moana.roadpro_manage.R;

import java.util.ArrayList;

public class BarChartFragment extends Fragment {
    protected BarChart mChart;
    protected int ColorArray[];
    protected ArrayList<IBarDataSet> mDataSet;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ColorArray = new int[]{getResources().getColor(R.color.colorLine1),
                getResources().getColor(R.color.colorLine3)};
        mDataSet = new ArrayList<>();
        initChart(view);
    }

    private void initChart(View view) {
        mChart = (BarChart) view.findViewById(R.id.bar_chart);
        mChart.getDescription().setEnabled(false);
        mChart.setMaxVisibleValueCount(60);
        mChart.setPinchZoom(false);
        mChart.setDrawBarShadow(false);
        mChart.setDrawGridBackground(false);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.animateY(2000);

        mChart.getLegend().setEnabled(false);
    }

    protected void draw() {
        if (mDataSet == null) return;

        // clear chart
        if (mChart.getData() != null && mChart.getData().getDataSetCount() > 0) {
            mChart.clear();
        }

        BarData data = new BarData(mDataSet);
        mChart.setData(data);
        mChart.notifyDataSetChanged();
        mChart.invalidate();
    }

    protected void addBarData(ArrayList<BarEntry> values) {
        BarDataSet barDataSet = new BarDataSet(values, "Data Set");
        barDataSet.setColors(ColorArray);
        barDataSet.setDrawValues(false);

        mDataSet.clear();
        mDataSet.add(barDataSet);
    }
}
