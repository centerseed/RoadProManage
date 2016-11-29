package com.moana.roadpro_manage.car.report;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.github.mikephil.charting.data.Entry;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.chart.DayAxisValueFormatter;
import com.moana.roadpro_manage.base.chart.LineChartFragment;

import java.util.ArrayList;
import java.util.Calendar;

public class ProperRateFragment extends LineChartFragment {

    EditText mStartTime;
    EditText mEndTime;

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

        mStartTime = (EditText) view.findViewById(R.id.start_time);
        mEndTime = (EditText) view.findViewById(R.id.end_time);

        mStartTime.setOnClickListener(new DatePickListener());
        mEndTime.setOnClickListener(new DatePickListener());
    }

    @Override
    public void onResume() {
        super.onResume();
        mChart.getXAxis().setValueFormatter(new DayAxisValueFormatter(mChart));

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

    public class DatePickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            final EditText editText = (EditText) view;
            final Calendar c = Calendar.getInstance();

            int year, month, day;
            year = c.get(Calendar.YEAR);
            month = c.get(Calendar.MONTH) + 1;
            day = c.get(Calendar.DATE);

            DatePickerDialog dpd = new DatePickerDialog(getActivity(),
                    new DatePickerDialog.OnDateSetListener() {
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {
                            // 完成選擇，顯示日期
                            c.set(year, monthOfYear, dayOfMonth);
                            editText.setText(year + "/" + (monthOfYear + 1) + "/"
                                    + dayOfMonth);
                        }
                    }, year, --month, day);
            dpd.show();
        }
    }
}
