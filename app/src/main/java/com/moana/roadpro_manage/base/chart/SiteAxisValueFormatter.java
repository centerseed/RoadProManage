package com.moana.roadpro_manage.base.chart;

import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

public class SiteAxisValueFormatter implements IAxisValueFormatter {

    protected String[] mMonths = new String[]{
            "東區", "西區", "南區", "北區", "中區", "北屯", "西屯", "南屯", "太平", "烏日"
    };


    public SiteAxisValueFormatter() {
    }

    @Override
    public String getFormattedValue(float value, AxisBase axis) {

        int region = (int) value;
        return mMonths[region];
    }

    @Override
    public int getDecimalDigits() {
        return 0;
    }
}