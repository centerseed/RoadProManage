package com.moana.roadpro_manage.park;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.RecyclerHeaderFragment;
import com.moana.roadpro_manage.dummy.DummyCarSource;
import com.moana.roadpro_manage.dummy.DummyParkSource;
import com.moana.roadpro_manage.dummy.DummyPlugSource;
import com.moana.roadpro_manage.plug.PlugRevenueAdapter;

import java.util.ArrayList;

public class ParkRevenueListFragment extends RecyclerHeaderFragment{
    @Override
    protected AbstractRecyclerCursorAdapter getAdapter() {
        return new ParkRevenueAdapter(getContext(), null);
    }

    @Override
    protected void onSync() {
        ContentResolver resolver = getContext().getContentResolver();
        resolver.delete(mUri, RoadProProvider.FIELD_ID + "!=0", null);
        ArrayList<ContentValues> values = DummyParkSource.getParkRevenueReportData(1472688000);
        for (ContentValues v : values) {
            resolver.insert(mUri, v);
        }
        resolver.notifyChange(mUri, null);
        enableRefresh(false);
    }

    @Override
    protected int getHeaderResID() {
        return R.layout.listitem_revenue_header;
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR_REVENUE);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = (CursorLoader) super.onCreateLoader(id, args);
        cl.setSortOrder(RoadProProvider.FIELD_PLUG_REVENUE_NET + " DESC");
        return cl;
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }
}
