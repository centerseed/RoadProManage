package com.moana.roadpro_manage.car;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.base.RecyclerFragment;
import com.moana.roadpro_manage.dummy.DummyCuringSource;

import java.util.ArrayList;

public class CarMaintainFragment extends RecyclerFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    public static CarMaintainFragment getInstance(String carNo) {
        Bundle bundle = new Bundle();
        bundle.putString(ConstantDef.ARG_STRING, carNo);

        CarMaintainFragment f = new CarMaintainFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = (CursorLoader) super.onCreateLoader(id, args);
        cl.setSelection(RoadProProvider.FIELD_CAR_NO + "=?");
        cl.setSelectionArgs(new String[]{getCarNo()});
        return cl;
    }

    @Override
    protected AbstractRecyclerCursorAdapter getAdapter() {
        return new CarMaintainAdapter(getContext(), null);
    }

    @Override
    protected void onSync() {

        ArrayList<ContentValues> values = DummyCuringSource.getMaintainData();
        for (ContentValues v : values) {
            getContext().getContentResolver().insert(mUri, v);
        }

        getContext().getContentResolver().notifyChange(mUri, null);
        enableRefresh(false);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_MAINTAIN);
    }

    private String getCarNo() {
        return getArguments().getString(ConstantDef.ARG_STRING);
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }
}
