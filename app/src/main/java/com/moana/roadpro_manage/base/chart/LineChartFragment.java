package com.moana.roadpro_manage.base.chart;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.moana.roadpro_manage.R;

import java.util.ArrayList;

public class LineChartFragment extends Fragment {

    protected LineChart mChart;
    protected ArrayList<ILineDataSet> mDataSet;

    int ColorArray[];

    public LineChartFragment() {
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mDataSet = new ArrayList<>();
        ColorArray = new int[] {getResources().getColor(R.color.colorLine1),
                getResources().getColor(R.color.colorLine2),
                getResources().getColor(R.color.colorLine3),
                getResources().getColor(R.color.colorLine4)};
        initChart(view);
    }

    private void initChart(View view) {
        mChart = (LineChart) view.findViewById(R.id.line_chart);

        mChart.setTouchEnabled(true);
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setPinchZoom(true);

        mChart.animateX(1500);

        setXAxis();
        setYAxis();
    }

    private void setXAxis() {
        XAxis mXAxis = mChart.getXAxis();
        mXAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        mXAxis.setDrawGridLines(false);
    }

    private void setYAxis() {
        YAxis mYaxis = mChart.getAxisLeft();
        mYaxis.setEnabled(true);
        mYaxis.setGranularityEnabled(true);

        YAxis rYAxis = mChart.getAxisRight();
        rYAxis.setEnabled(false);
    }

    protected void draw() {
        if (mDataSet == null) return;

        // clear chart
        if (mChart.getData() != null && mChart.getData().getDataSetCount() > 0) {
            mChart.clear();
        }

        LineData data = new LineData(mDataSet);
        mChart.setData(data);
        mChart.notifyDataSetChanged();
        mChart.invalidate();
    }

    protected void addLineData(ArrayList<Entry> values, String name) {
        LineDataSet lineDataSet = new LineDataSet(values, name);
        lineDataSet.setColor(getLineColor(mDataSet.size()));
        lineDataSet.setCircleColor(getLineColor(mDataSet.size()));
        lineDataSet.setLineWidth(1.5f);
        lineDataSet.setCircleRadius(3f);
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setValueTextSize(9f);
        lineDataSet.setDrawFilled(false);
        lineDataSet.setFormLineWidth(1f);
        lineDataSet.setFormSize(15.f);

        mDataSet.add(lineDataSet);
    }

    private int getLineColor(int i) {
        return ColorArray[i%4];
    }
}
