package com.moana.roadpro_manage.ev_car;


import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.base.ContentFragment;

public class CarBasicFragment extends ContentFragment {

    public CarBasicFragment() {
    }

    public static CarBasicFragment getInstance(String carNo) {
        Bundle bundle = new Bundle();
        bundle.putString(ConstantDef.ARG_STRING, carNo);

        CarBasicFragment f = new CarBasicFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car_basic, container, false);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_MAINTAIN);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = (CursorLoader) super.onCreateLoader(id, args);
        cl.setSelection(RoadProProvider.FIELD_CAR_NO + "=?");
        cl.setSelectionArgs(new String[]{getCarNo()});
        return cl;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private String getCarNo() {
        return getArguments().getString(ConstantDef.ARG_STRING);
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }
}
