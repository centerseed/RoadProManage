package com.moana.roadpro_manage.ev_car;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.base.RecyclerFragment;

public class CarMaintainFragment extends RecyclerFragment {

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
    protected String getTitle() {
        return null;
    }

    @Override
    protected void onSync() {
        enableRefresh(false);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_MAINTAIN);
    }

    private String getCarNo() {
        return getArguments().getString(ConstantDef.ARG_STRING);
    }
}
