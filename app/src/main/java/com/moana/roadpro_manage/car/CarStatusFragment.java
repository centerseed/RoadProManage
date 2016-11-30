package com.moana.roadpro_manage.car;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.ContentFragment;
import com.moana.roadpro_manage.map.ContentMapFragment;

public class CarStatusFragment extends ContentFragment implements ContentMapFragment.MapClickListener {

    LinearLayout mIntroduce;
    LinearLayout mCarStatus;
    ContentMapFragment mMapFragment;

    TextView mDriverName;
    TextView mMileage;
    TextView mSoc;
    TextView mBatteryTemp;
    TextView mVoltage;
    TextView mSingleVoltage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ev_car_status, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMapFragment = new CarMapFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, mMapFragment).commit();

        mIntroduce = (LinearLayout) view.findViewById(R.id.header_intro);

        mCarStatus = (LinearLayout) view.findViewById(R.id.header_car_status);
        mMileage = (TextView) mCarStatus.findViewById(R.id.mileage);
        mSoc = (TextView) mCarStatus.findViewById(R.id.soc);
        mDriverName = (TextView) mCarStatus.findViewById(R.id.driver_name);
        mBatteryTemp = (TextView) mCarStatus.findViewById(R.id.battery_temp);
        mVoltage = (TextView) mCarStatus.findViewById(R.id.voltage);
        mSingleVoltage = (TextView) mCarStatus.findViewById(R.id.single_voltage);

        showIntroduce();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapFragment.setMapClickListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapFragment.setMapClickListener(null);
    }

    @Override
    protected String getActionBarTitle() {
        return "車輛動態";
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void showIntroduce() {
        mIntroduce.setVisibility(View.VISIBLE);
        mCarStatus.setVisibility(View.GONE);
    }

    private void showCarStatus(String carNO) {
        mIntroduce.setVisibility(View.GONE);
        mCarStatus.setVisibility(View.VISIBLE);

        Cursor cursor = getContext().getContentResolver().query(mUri, null, RoadProProvider.FIELD_CAR_NO + "=?", new String[]{carNO}, null);
        if (cursor.moveToFirst()) {
            mDriverName.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_DRIVER_NAME)));
            mMileage.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_MILEAGE)));
            mSoc.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_SOC)));
            mBatteryTemp.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_BATTERY_TEMP)));
            mVoltage.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_VOLTAGE)));
            mSingleVoltage.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_SINGLE_VOLTAGE)));
        }
        cursor.close();
    }

    @Override
    public void onMapMarkerClick(String cardNO) {
        showCarStatus(cardNO);
    }

    @Override
    public void onMapClick() {
        showIntroduce();
    }

}
