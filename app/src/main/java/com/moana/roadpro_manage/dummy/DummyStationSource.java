package com.moana.roadpro_manage.dummy;

import android.content.ContentValues;

import com.moana.roadpro_manage.RoadProProvider;

import java.util.ArrayList;

public class DummyStationSource {

    public static ArrayList<ContentValues> getPlugList() {
        ArrayList<ContentValues> arrayList = new ArrayList<>();

        // Dummy 1
        ContentValues values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug1".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "都會南");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "台中市龍井區都會南街151號");
        values.put(RoadProProvider.FIELD_LAT, 24.1900696);
        values.put(RoadProProvider.FIELD_LNG, 120.5839046);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "");
        values.put(RoadProProvider.FIELD_TOTAL, 18);
        values.put(RoadProProvider.FIELD_USAGE, 5);
        arrayList.add(values);

        // Dummy 2
        values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug2".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "雲林客運");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "雲林縣斗六市大學路三段100號");
        values.put(RoadProProvider.FIELD_LAT, 23.6969719);
        values.put(RoadProProvider.FIELD_LNG, 120.5338262);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "");
        values.put(RoadProProvider.FIELD_TOTAL, 13);
        values.put(RoadProProvider.FIELD_USAGE, 4);
        arrayList.add(values);

        // Dummy 3
        values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug3".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "花蓮東華站");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "花蓮縣壽豐鄉大學路二段1號");
        values.put(RoadProProvider.FIELD_LAT, 23.8943519);
        values.put(RoadProProvider.FIELD_LNG, 121.5411446);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "http://www.walkerland.com.tw/images/upload/poi/p4608/m37349/19031d6da4e425c0e8c211b1219caad7c0fd1283.jpg");
        values.put(RoadProProvider.FIELD_TOTAL, 10);
        values.put(RoadProProvider.FIELD_USAGE, 4);
        arrayList.add(values);

        // Dummy 4
        values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug4".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "桃園大溪");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "桃園市大溪區瑞安路二段235號");
        values.put(RoadProProvider.FIELD_LAT, 24.8669494);
        values.put(RoadProProvider.FIELD_LNG, 121.2645276);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "");
        values.put(RoadProProvider.FIELD_TOTAL, 15);
        values.put(RoadProProvider.FIELD_USAGE, 4);
        arrayList.add(values);

        // Dummy 5
        values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug5".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "嘉義太保");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "嘉義縣太保市高鐵西路168號");
        values.put(RoadProProvider.FIELD_LAT, 23.458967);
        values.put(RoadProProvider.FIELD_LNG, 120.3207159);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "http://mw2.google.com/mw-panoramio/photos/medium/16588921.jpg");
        values.put(RoadProProvider.FIELD_TOTAL, 8);
        values.put(RoadProProvider.FIELD_USAGE, 0);
        arrayList.add(values);

        // Dummy 6
        values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug6".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "花連新城站");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "花蓮縣新城鄉新興路30-1號");
        values.put(RoadProProvider.FIELD_LAT, 24.1310352);
        values.put(RoadProProvider.FIELD_LNG, 121.6431411);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "http://farm9.staticflickr.com/8192/8111989824_8d167d834c.jpg");
        values.put(RoadProProvider.FIELD_TOTAL, 5);
        values.put(RoadProProvider.FIELD_USAGE, 4);
        arrayList.add(values);

        // Dummy 7
        values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug7".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "神岡停車場");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "台中市神岡區大富路20巷47號");
        values.put(RoadProProvider.FIELD_LAT, 24.2568513);
        values.put(RoadProProvider.FIELD_LNG, 120.7101598);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "");
        values.put(RoadProProvider.FIELD_TOTAL, 42);
        values.put(RoadProProvider.FIELD_USAGE, 0);
        arrayList.add(values);

        // Dummy 8
        values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug8".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "嘉義阿里山客運停車場");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "嘉義縣太保市保鐵七路");
        values.put(RoadProProvider.FIELD_LAT, 23.453725);
        values.put(RoadProProvider.FIELD_LNG, 120.3190169);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "");
        values.put(RoadProProvider.FIELD_TOTAL, 10);
        values.put(RoadProProvider.FIELD_USAGE, 0);
        arrayList.add(values);

        // Dummy 9
        values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug9".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "高雄南臺灣客運停車場");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "高雄市仁武區高鐵路1999號");
        values.put(RoadProProvider.FIELD_LAT, 22.6945);
        values.put(RoadProProvider.FIELD_LNG, 120.3192946);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "");
        values.put(RoadProProvider.FIELD_TOTAL, 5);
        values.put(RoadProProvider.FIELD_USAGE, 0);
        arrayList.add(values);

        // Dummy 10
        values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug10".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "苗栗客運-1");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "苗栗縣苑裡鎮苑港里5-1號");
        values.put(RoadProProvider.FIELD_LAT, 24.561156);
        values.put(RoadProProvider.FIELD_LNG, 120.8195553);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "");
        values.put(RoadProProvider.FIELD_TOTAL, 3);
        values.put(RoadProProvider.FIELD_USAGE, 0);
        arrayList.add(values);

        // Dummy 11
        values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug11".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "苗栗客運-2");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "苗栗市水源里7鄰水源24之2號");
        values.put(RoadProProvider.FIELD_LAT, 24.5409306);
        values.put(RoadProProvider.FIELD_LNG, 120.8091391);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "");
        values.put(RoadProProvider.FIELD_TOTAL, 3);
        values.put(RoadProProvider.FIELD_USAGE, 0);
        arrayList.add(values);

        // Dummy 12
        values = new ContentValues();
        values.put(RoadProProvider.FIELD_ID, "plug12".hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, "車麗屋");
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, "新北市板橋區中山路一段277號");
        values.put(RoadProProvider.FIELD_LAT, 25.0139465);
        values.put(RoadProProvider.FIELD_LNG, 121.4670474);
        values.put(RoadProProvider.FIELD_PLUG_STATION_PHOTO, "http://www.carshop.com.tw/images/car_quality_goodle_3.jpg");
        values.put(RoadProProvider.FIELD_TOTAL, 10);
        values.put(RoadProProvider.FIELD_USAGE, 0);
        arrayList.add(values);

        return arrayList;
    }
}
