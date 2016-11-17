package com.moana.roadpro_manage.dummy;


import android.content.ContentValues;

import com.moana.roadpro_manage.RoadProProvider;

import java.util.ArrayList;

public class DummyMaintainSource {
    public static ArrayList<ContentValues> getCarData() {
        ArrayList<ContentValues> values = new ArrayList<>();

        ContentValues value = new ContentValues();
        String carNO = "1111-00";

        value.put(RoadProProvider.FIELD_ID, carNO.hashCode());
        value.put(RoadProProvider.FIELD_CAR_ADDRESS, "台中市五權路一段");
        value.put(RoadProProvider.FIELD_CAR_BATTERY_TEMP, "50");
        value.put(RoadProProvider.FIELD_CAR_DRIVER_NAME, "王大明");
        value.put(RoadProProvider.FIELD_CAR_COLOR, "白色");
        value.put(RoadProProvider.FIELD_CAR_FACTORY_YEAR, "2016/5");
        value.put(RoadProProvider.FIELD_CAR_FUEL_TYPE, "電動車");

        values.add(value);
        return values;
    }
}
