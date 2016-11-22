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

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.ContentFragment;
import com.moana.roadpro_manage.map.ContentMapFragment;

public class CarStatusFragment extends ContentFragment implements ContentMapFragment.MapClickListener {

    LinearLayout mIntroduce;
    LinearLayout mCarStatus;
    ContentMapFragment mMapFragment;

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
        return null;
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

    private void showCarStatus() {
        mIntroduce.setVisibility(View.GONE);
        mCarStatus.setVisibility(View.VISIBLE);

    }

    @Override
    public void onMapMarkerClick(String cardNO) {
        showCarStatus();
    }

    @Override
    public void onMapClick() {
        showIntroduce();
    }
}
