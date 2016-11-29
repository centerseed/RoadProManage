package com.moana.roadpro_manage.dummy;

import android.content.ContentValues;

import com.moana.roadpro_manage.RoadProProvider;

import java.util.ArrayList;

public class DummyPlugSource {
    public static ArrayList<ContentValues> getPlugDayReportData(long time) {
        ArrayList<ContentValues> values = new ArrayList<>();

        ContentValues value = new ContentValues();
        String id = "plug1";
        String unit = "day";

        value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
        value.put(RoadProProvider.FIELD_PLUG_STATION_ID, id.hashCode());
        value.put(RoadProProvider.FIELD_PLUG_USAGE, "50");
        value.put(RoadProProvider.FIELD_PLUG_REVENUE, "500");
        value.put(RoadProProvider.FIELD_TIME, time);
        value.put(RoadProProvider.FIELD_TIME_UNIT, unit);
        values.add(value);

        value = new ContentValues();
        id = "plug2";
        value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
        value.put(RoadProProvider.FIELD_PLUG_STATION_ID, id.hashCode());
        value.put(RoadProProvider.FIELD_PLUG_USAGE, "60");
        value.put(RoadProProvider.FIELD_PLUG_REVENUE, "670");
        value.put(RoadProProvider.FIELD_TIME, time);
        value.put(RoadProProvider.FIELD_TIME_UNIT, unit);
        values.add(value);

        value = new ContentValues();
        id = "plug3";
        value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
        value.put(RoadProProvider.FIELD_PLUG_STATION_ID, id.hashCode());
        value.put(RoadProProvider.FIELD_PLUG_USAGE, "50");
        value.put(RoadProProvider.FIELD_PLUG_REVENUE, "550");
        value.put(RoadProProvider.FIELD_TIME, time);
        value.put(RoadProProvider.FIELD_TIME_UNIT, unit);
        values.add(value);

        value = new ContentValues();
        id = "plug4";
        value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
        value.put(RoadProProvider.FIELD_PLUG_STATION_ID, id.hashCode());
        value.put(RoadProProvider.FIELD_PLUG_USAGE, "30");
        value.put(RoadProProvider.FIELD_PLUG_REVENUE, "320");
        value.put(RoadProProvider.FIELD_TIME, time);
        value.put(RoadProProvider.FIELD_TIME_UNIT, unit);
        values.add(value);

        value = new ContentValues();
        id = "plug5";
        value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
        value.put(RoadProProvider.FIELD_PLUG_STATION_ID, id.hashCode());
        value.put(RoadProProvider.FIELD_PLUG_USAGE, "40");
        value.put(RoadProProvider.FIELD_PLUG_REVENUE, "450");
        value.put(RoadProProvider.FIELD_TIME, time);
        value.put(RoadProProvider.FIELD_TIME_UNIT, unit);
        values.add(value);

        value = new ContentValues();
        id = "plug6";
        value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
        value.put(RoadProProvider.FIELD_PLUG_STATION_ID, id.hashCode());
        value.put(RoadProProvider.FIELD_PLUG_USAGE, "30");
        value.put(RoadProProvider.FIELD_PLUG_REVENUE, "200");
        value.put(RoadProProvider.FIELD_TIME, time);
        value.put(RoadProProvider.FIELD_TIME_UNIT, unit);
        values.add(value);

        value = new ContentValues();
        id = "plug7";
        value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
        value.put(RoadProProvider.FIELD_PLUG_STATION_ID, id.hashCode());
        value.put(RoadProProvider.FIELD_PLUG_USAGE, "42");
        value.put(RoadProProvider.FIELD_PLUG_REVENUE, "420");
        value.put(RoadProProvider.FIELD_TIME, time);
        value.put(RoadProProvider.FIELD_TIME_UNIT, unit);
        values.add(value);

        value = new ContentValues();
        id = "plug8";
        value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
        value.put(RoadProProvider.FIELD_PLUG_STATION_ID, id.hashCode());
        value.put(RoadProProvider.FIELD_PLUG_USAGE, "31");
        value.put(RoadProProvider.FIELD_PLUG_REVENUE, "340");
        value.put(RoadProProvider.FIELD_TIME, time);
        value.put(RoadProProvider.FIELD_TIME_UNIT, unit);
        values.add(value);

        value = new ContentValues();
        id = "plug9";
        value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
        value.put(RoadProProvider.FIELD_PLUG_STATION_ID, id.hashCode());
        value.put(RoadProProvider.FIELD_PLUG_USAGE, "47");
        value.put(RoadProProvider.FIELD_PLUG_REVENUE, "510");
        value.put(RoadProProvider.FIELD_TIME, time);
        value.put(RoadProProvider.FIELD_TIME_UNIT, unit);
        values.add(value);

        value = new ContentValues();
        id = "plug10";
        value.put(RoadProProvider.FIELD_ID, (id + time + unit).hashCode());
        value.put(RoadProProvider.FIELD_PLUG_STATION_ID, id.hashCode());
        value.put(RoadProProvider.FIELD_PLUG_USAGE, "43");
        value.put(RoadProProvider.FIELD_PLUG_REVENUE, "450");
        value.put(RoadProProvider.FIELD_TIME, time);
        value.put(RoadProProvider.FIELD_TIME_UNIT, unit);
        values.add(value);

        values.add(value);
        return values;
    }
}
