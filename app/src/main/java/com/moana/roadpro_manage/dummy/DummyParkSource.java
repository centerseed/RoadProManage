package com.moana.roadpro_manage.dummy;

import android.content.ContentValues;

import com.moana.roadpro_manage.RoadProProvider;

import java.util.ArrayList;

public class DummyParkSource {

    public static ArrayList<ContentValues> getParkDayReportData(long time) {
        ArrayList<ContentValues> values = new ArrayList<>();

        String unit = "day";

        for (int i = 1; i < 10; i++) {
            String id = "rent" + i;
            ContentValues value = new ContentValues();
            value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
            value.put(RoadProProvider.FIELD_CAR_STATION_ID, id.hashCode());
            value.put(RoadProProvider.FIELD_CAR_REPORT_RENT_COUNT, Dummy.getRandomInt(10, 50));
            value.put(RoadProProvider.FIELD_CAR_REPORT_TURNOVER, Dummy.getRandomInt(10, 90));
            value.put(RoadProProvider.FIELD_TIME, time);
            value.put(RoadProProvider.FIELD_TIME_UNIT, unit);
            values.add(value);
        }

        return values;
    }

    public static ArrayList<ContentValues> getPlugRevenueReportData(long time) {
        ArrayList<ContentValues> values = new ArrayList<>();

        String unit = "day";

        for (int i = 1; i < 11; i++) {
            String id = "plug" + i;
            ContentValues value = new ContentValues();
            int rent = Dummy.getRandomInt(1000, 3000);
            int other = Dummy.getRandomInt(700, 2000);
            value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
            value.put(RoadProProvider.FIELD_PLUG_STATION_ID, id.hashCode());
            value.put(RoadProProvider.FIELD_PLUG_REVENUE_RENT_INCOME, rent);
            value.put(RoadProProvider.FIELD_PLUG_REVENUE_OTHER_INCOME, other);
            value.put(RoadProProvider.FIELD_PLUG_REVENUE_DATE, i);
            value.put(RoadProProvider.FIELD_PLUG_REVENUE_NET, rent + other);
            values.add(value);
        }

        return values;
    }
}
