package com.moana.roadpro_manage.ev_car.report;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moana.roadpro_manage.R;

public class RepairRecordFragment extends Fragment {


    public RepairRecordFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_repair_record, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Fragment pie = new RepairPieChartFragment();
        getChildFragmentManager().beginTransaction().replace(R.id.container_pie, pie).commit();

        Fragment bar = new RepareBarChartFragment();
        getChildFragmentManager().beginTransaction().replace(R.id.container_bar, bar).commit();
    }
}
