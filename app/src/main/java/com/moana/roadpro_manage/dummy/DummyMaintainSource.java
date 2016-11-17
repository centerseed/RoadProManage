package com.moana.roadpro_manage.dummy;


import android.content.ContentValues;

import com.moana.roadpro_manage.RoadProProvider;

import java.util.ArrayList;

public class DummyMaintainSource {
    public static ArrayList<ContentValues> getMaintainData() {
        ArrayList<ContentValues> values = new ArrayList<>();
        String carNO = "1111-00";

        ContentValues value = new ContentValues();
        value.put(RoadProProvider.FIELD_ID, "maintain1".hashCode());
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/4/2");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM, "故障維修");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL, "更換空壓機");
        value.put(RoadProProvider.FIELD_MAINTAIN_REASON, "空壓氣漏油");
        value.put(RoadProProvider.FIELD_MAINTAIN_MILEAGE, "4123");

        values.add(value);

        value = new ContentValues();
        value.put(RoadProProvider.FIELD_ID, "maintain2".hashCode());
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/5/10");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM, "例行保養");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL, "更換輪胎");
        value.put(RoadProProvider.FIELD_MAINTAIN_REASON, "二級保養");
        value.put(RoadProProvider.FIELD_MAINTAIN_MILEAGE, "4123");

        values.add(value);
        return values;
    }
}
