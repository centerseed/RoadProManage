package com.moana.roadpro_manage.park;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.data.BarEntry;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.chart.SiteAxisValueFormatter;
import com.moana.roadpro_manage.base.chart.StackBarChartFragment;

import java.util.ArrayList;

public class TurnoverChartFragment extends StackBarChartFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bar_chart, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mChart.getXAxis().setValueFormatter(new SiteAxisValueFormatter());
    }

    @Override
    public void onResume() {
        super.onResume();

        addBarData(getDummyData(10, 100));
        draw();
    }

    private ArrayList<BarEntry> getDummyData(int count, int range) {
        ArrayList<BarEntry> values = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            float val = (float) (Math.random() * range);
            float val1 = (float) (Math.random() * range);
            values.add(new BarEntry(i, new float[]{val, val1}));
        }
        return values;
    }
}
