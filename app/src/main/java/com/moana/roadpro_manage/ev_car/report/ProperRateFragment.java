package com.moana.roadpro_manage.ev_car.report;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.data.Entry;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.chart.LineChartFragment;

import java.util.ArrayList;

public class ProperRateFragment extends LineChartFragment {


    public ProperRateFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_proper_rate, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        addLineData(getDummyData(12, 100), "111-00");
        addLineData(getDummyData(12, 100), "111-01");

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
}
