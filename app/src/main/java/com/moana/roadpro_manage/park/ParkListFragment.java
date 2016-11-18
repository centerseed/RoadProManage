package com.moana.roadpro_manage.park;

import android.content.ContentValues;
import android.net.Uri;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.RecyclerFragment;
import com.moana.roadpro_manage.dummy.DummyCarSource;
import com.moana.roadpro_manage.ev_car.CarAdapter;

import java.util.ArrayList;

public class ParkListFragment extends RecyclerFragment {
    @Override
    protected AbstractRecyclerCursorAdapter getAdapter() {
        return new CarAdapter(getContext(), null);
    }

    @Override
    protected void onSync() {
        // Skip parser
        getContext().getContentResolver().delete(mUri, RoadProProvider.FIELD_ID + "!=?", new String[]{"0"});

        ArrayList<ContentValues> values = DummyCarSource.getCarData();
        for (ContentValues v : values)
            getContext().getContentResolver().insert(mUri, v);

        getContext().getContentResolver().notifyChange(mUri, null);
        enableRefresh(false);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR);
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }
}
