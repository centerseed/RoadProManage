package com.moana.roadpro_manage.dummy;


import android.content.ContentValues;

import com.moana.roadpro_manage.RoadProProvider;

import java.util.ArrayList;

public class DummyCuringSource {
    public static ArrayList<ContentValues> getRepairData() {
        ArrayList<ContentValues> values = new ArrayList<>();
        String carNO = "1111-00";

        ContentValues value = new ContentValues();
        value.put(RoadProProvider.FIELD_ID, "Repair1".hashCode());
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/4/2");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM, "repair");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL, "更換空壓機");
        value.put(RoadProProvider.FIELD_MAINTAIN_REASON, "空壓氣漏油");
        value.put(RoadProProvider.FIELD_MAINTAIN_MILEAGE, "1298");
        values.add(value);

        value = new ContentValues();
        value.put(RoadProProvider.FIELD_ID, "Repair2".hashCode());
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/5/10");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM, "repair");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL, "更換輪胎");
        value.put(RoadProProvider.FIELD_MAINTAIN_REASON, "輪胎破損");
        value.put(RoadProProvider.FIELD_MAINTAIN_MILEAGE, "3673");
        values.add(value);

        value = new ContentValues();
        carNO = "1111-01";
        value.put(RoadProProvider.FIELD_ID, "repair3".hashCode());
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/10/24");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM, "repair");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL, "更換後照鏡總成");
        value.put(RoadProProvider.FIELD_MAINTAIN_REASON, "後照鏡破損");
        value.put(RoadProProvider.FIELD_MAINTAIN_MILEAGE, "2234");
        values.add(value);
        return values;
    }

    public static ArrayList<ContentValues> getMaintainData() {
        ArrayList<ContentValues> values = new ArrayList<>();
        String carNO = "1111-00";

        ContentValues value = new ContentValues();
        value.put(RoadProProvider.FIELD_ID, "maintain1".hashCode());
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/4/2");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM, "maintain");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL, "更換冷媒");
        value.put(RoadProProvider.FIELD_MAINTAIN_REASON, "冷氣不冷");
        value.put(RoadProProvider.FIELD_MAINTAIN_MILEAGE, "2212");

        values.add(value);

        value = new ContentValues();
        value.put(RoadProProvider.FIELD_ID, "maintain2".hashCode());
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/7/20");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM, "maintain");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL, "清理電刷");
        value.put(RoadProProvider.FIELD_MAINTAIN_REASON, "二級保養");
        value.put(RoadProProvider.FIELD_MAINTAIN_MILEAGE, "4451");

        value = new ContentValues();
        carNO = "1111-01";
        value.put(RoadProProvider.FIELD_ID, "maintain3".hashCode());
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/8/20");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM, "maintain");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL, "清理電刷");
        value.put(RoadProProvider.FIELD_MAINTAIN_REASON, "一級保養");
        value.put(RoadProProvider.FIELD_MAINTAIN_MILEAGE, "2234");

        values.add(value);
        return values;
    }

    public static ArrayList<ContentValues> getCleanData() {
        ArrayList<ContentValues> values = new ArrayList<>();
        String carNO = "1111-00";

        ContentValues value = new ContentValues();
        value.put(RoadProProvider.FIELD_ID, "clean1".hashCode());
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/8/2");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM, "clean");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL, "板金清潔");
        value.put(RoadProProvider.FIELD_MAINTAIN_REASON, "一般清潔");
        value.put(RoadProProvider.FIELD_MAINTAIN_MILEAGE, "4123");

        values.add(value);

        value = new ContentValues();
        carNO = "1111-01";
        value.put(RoadProProvider.FIELD_ID, "clean2".hashCode());
        value.put(RoadProProvider.FIELD_CAR_NO, carNO);
        value.put(RoadProProvider.FIELD_CAR_MAINTAIN_DATE, "2016/11/10");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM, "clean");
        value.put(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL, "清潔踏墊，沙發");
        value.put(RoadProProvider.FIELD_MAINTAIN_REASON, "內裝清潔");
        value.put(RoadProProvider.FIELD_MAINTAIN_MILEAGE, "4123");

        values.add(value);
        return values;
    }
}
