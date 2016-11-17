package com.moana.roadpro_manage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.moana.roadpro_manage.base.BaseContentProvider;

public class RoadProProvider extends BaseContentProvider {

    public final static String TABLE_CAR = "_table_car";
    public final static String TABLE_MAINTAIN = "_table_maintain";

    public final static String FIELD_LAT = "_lnt";
    public final static String FIELD_LNG = "_lng";

    public final static String FIELD_CAR_NO = "_car_no";
    public final static String FIELD_CAR_FACTORY_YEAR = "_car_factory_year";
    public final static String FIELD_CAR_MAINTAIN_DATE= "_car_maintain_day";
    public final static String FIELD_CAR_MILEAGE = "_car_mileage";
    public final static String FIELD_CAR_DRIVER_NAME = "_car_driver_name";
    public final static String FIELD_CAR_SOC = "_car_soc";
    public final static String FIELD_CAR_BATTERY_TEMP = "_battery_temp";
    public final static String FIELD_CAR_VOLTAGE = "_car_voltage";
    public final static String FIELD_CAR_SINGLE_VOLTAGE = "_car_single_voltage";
    public final static String FIELD_CAR_OWNER = "_car_owner";
    public final static String FIELD_CAR_TYPE = "_car_type";
    public final static String FIELD_CAR_ADDRESS = "_car_address";
    public final static String FIELD_CAR_COLOR = "_car_color";
    public final static String FIELD_CAR_FUEL_TYPE = "_car_fuel_type";
    public final static String FIELD_CAR_LICENSE_DATE = "_car_license_date";
    public final static String FIELD_CAR_CARRY_NUM = "_car_carry_num";

    public final static String FIELD_MAINTAIN_DATE = "_maintain_date";
    public final static String FIELD_MAINTAIN_MILEAGE = "_maintain_mileage";
    public final static String FIELD_MAINTAIN_ITEM = "_maintain_item";
    public final static String FIELD_MAINTAIN_ITEM_DETAIL = "_maintain_item_detail";
    public final static String FIELD_MAINTAIN_REASON = "_maintain_reason";

    @Override
    public boolean onCreate() {
        mDb = new RoadProDatabase(getContext());
        return false;
    }

    private class RoadProDatabase extends SQLiteOpenHelper {
        private final static int _DBVersion = 2;
        private final static String _DBName = "roadpro.db";


        public RoadProDatabase(Context context) {
            super(context, _DBName, null, _DBVersion);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_CAR + " ( "
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_CAR_NO + " TEXT, "
                    + FIELD_CAR_FACTORY_YEAR + " TEXT, "
                    + FIELD_CAR_MAINTAIN_DATE + " TEXT, "
                    + FIELD_CAR_MILEAGE + " TEXT, "
                    + FIELD_CAR_DRIVER_NAME + " TEXT, "
                    + FIELD_CAR_SOC + " TEXT, "
                    + FIELD_CAR_BATTERY_TEMP + " INTEGER, "
                    + FIELD_CAR_VOLTAGE + " FLOAT, "
                    + FIELD_CAR_SINGLE_VOLTAGE + " FLOAT, "
                    + FIELD_CAR_OWNER + " TEXT, "
                    + FIELD_CAR_TYPE + " TEXT, "
                    + FIELD_CAR_ADDRESS + " TEXT, "
                    + FIELD_CAR_COLOR + " TEXT, "
                    + FIELD_CAR_FUEL_TYPE + " TEXT, "
                    + FIELD_CAR_LICENSE_DATE + " TEXT, "
                    + FIELD_LAT + " TEXT, "
                    + FIELD_LNG + " TEXT, "
                    + FIELD_CAR_CARRY_NUM + " INTEGER "
                    + ");");

            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_MAINTAIN + " ( "
                    + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + FIELD_CAR_NO + " TEXT, "
                    + FIELD_MAINTAIN_DATE + " TEXT, "
                    + FIELD_MAINTAIN_MILEAGE + " TEXT, "
                    + FIELD_MAINTAIN_ITEM + " TEXT, "
                    + FIELD_MAINTAIN_ITEM_DETAIL + " TEXT, "
                    + FIELD_MAINTAIN_REASON + " TEXT "
                    + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CAR);
            onCreate(db);
        }
    }
}
