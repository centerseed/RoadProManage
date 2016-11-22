package com.moana.roadpro_manage.car.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.data.BarEntry;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.chart.BarChartFragment;

import java.util.ArrayList;

public class RepareBarChartFragment extends BarChartFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bar_chart, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();

        addBarData(getDummyData(12, 100));

        draw();
    }

    private ArrayList<BarEntry> getDummyData(int count, int range) {
        ArrayList<BarEntry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            values.add(new BarEntry(i, val));
        }
        return values;
    }
}
