package com.moana.roadpro_manage.park;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.chart.LineChartFragment;

import java.util.ArrayList;

public class UseCountChartFragment extends LineChartFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_line_chart, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        mChart.getLegend().setEnabled(false);
        addLineData(getDummyData(10, 50), "");
        draw();
    }

    private ArrayList<Entry> getDummyData(int count, int range) {
        ArrayList<Entry> values = new ArrayList<Entry>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            values.add(new Entry(i, val));
        }
        return values;
    }

    @Override
    protected void addLineData(ArrayList<Entry> values, String name) {
        super.addLineData(values, name);
        mDataSet.get(0).setDrawFilled(true);
        ((LineDataSet)mDataSet.get(0)).setFillColor(getResources().getColor(R.color.colorLine1));
    }
}
