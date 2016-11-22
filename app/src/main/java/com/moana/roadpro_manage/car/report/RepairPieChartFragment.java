package com.moana.roadpro_manage.car.report;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.chart.PieChartFragment;

import java.util.ArrayList;


public class RepairPieChartFragment extends PieChartFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repair_pie_chart, container, false);
    }

    @Override
    protected PieDataSet getDataSet() {
        ArrayList<PieEntry> entries = new ArrayList<PieEntry>();

        entries.add(new PieEntry(6.8f));
        entries.add(new PieEntry(27.2f));
        entries.add(new PieEntry(40.8f));
        entries.add(new PieEntry(40.8f));

        PieDataSet dataSet = new PieDataSet(entries, null);
        return dataSet;
    }

    @Override
    public void onResume() {
        super.onResume();

        draw();
    }
}
