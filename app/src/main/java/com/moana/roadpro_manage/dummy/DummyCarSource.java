package com.moana.roadpro_manage.dummy;

import android.content.ContentValues;

import com.moana.roadpro_manage.RoadProProvider;

import java.util.ArrayList;

public class DummyCarSource {
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
        value.put(RoadProProvider.FIELD_CAR_LICENSE_DATE, "2016/6");
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/10");
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_OWNER, "路得寶交通");
        value.put(RoadProProvider.FIELD_CAR_MILEAGE, "2000");
        value.put(RoadProProvider.FIELD_CAR_SOC, "90");
        value.put(RoadProProvider.FIELD_CAR_VOLTAGE, "120V");
        value.put(RoadProProvider.FIELD_CAR_SINGLE_VOLTAGE, "120V");
        value.put(RoadProProvider.FIELD_CAR_CARRY_NUM, "4");
        value.put(RoadProProvider.FIELD_LAT, 24.2568513);
        value.put(RoadProProvider.FIELD_LNG, 120.7101598);

        values.add(value);

        value = new ContentValues();
        carNO = "1111-01";
        value.put(RoadProProvider.FIELD_ID, carNO.hashCode());
        value.put(RoadProProvider.FIELD_CAR_ADDRESS, "台中市五權路一段");
        value.put(RoadProProvider.FIELD_CAR_BATTERY_TEMP, "45");
        value.put(RoadProProvider.FIELD_CAR_DRIVER_NAME, "王小明");
        value.put(RoadProProvider.FIELD_CAR_COLOR, "白色");
        value.put(RoadProProvider.FIELD_CAR_FACTORY_YEAR, "2016/4");
        value.put(RoadProProvider.FIELD_CAR_FUEL_TYPE, "電動車");
        value.put(RoadProProvider.FIELD_CAR_LICENSE_DATE, "2016/5");
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/11");
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_OWNER, "路得寶交通");
        value.put(RoadProProvider.FIELD_CAR_MILEAGE, "10134");
        value.put(RoadProProvider.FIELD_CAR_SOC, "92");
        value.put(RoadProProvider.FIELD_CAR_VOLTAGE, "120V");
        value.put(RoadProProvider.FIELD_CAR_SINGLE_VOLTAGE, "120V");
        value.put(RoadProProvider.FIELD_CAR_CARRY_NUM, "4");
        value.put(RoadProProvider.FIELD_LAT, 24.102473);
        value.put(RoadProProvider.FIELD_LNG, 120.7101598);

        values.add(value);
        return values;
    }
}
