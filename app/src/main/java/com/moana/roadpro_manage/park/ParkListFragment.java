package com.moana.roadpro_manage.park;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.MenuItem;
import android.view.View;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.base.FunctionRecyclerFragment;
import com.moana.roadpro_manage.dummy.DummyStationSource;

import java.util.ArrayList;

public class ParkListFragment extends FunctionRecyclerFragment implements ParkAdapter.ParkClickListener {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((ParkAdapter) mAdapter).setParkClickListener(this);
    }

    @Override
    protected AbstractRecyclerCursorAdapter getAdapter() {
        return new ParkAdapter(getContext(), null);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_add_park:
                Intent intent = new Intent(getActivity(), ParkEditInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.action_delete:
                ((ParkAdapter) mAdapter).toggleDelete();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = (CursorLoader) super.onCreateLoader(id, args);
        if (mSearchText.length() > 0)
            cl.setSelection("(" + RoadProProvider.FIELD_CAR_STATION_NAME + " like '%" + mSearchText + "%' or " + RoadProProvider.FIELD_CAR_STATION_ADDRESS + " like '%" + mSearchText + "%')");
        else
            cl.setSelection(RoadProProvider.FIELD_ID + "!=0");
        return cl;
    }

    @Override
    protected void onSync() {
        // Skip parser
        getContext().getContentResolver().delete(mUri, RoadProProvider.FIELD_ID + "!=?", new String[]{"0"});

        ArrayList<ContentValues> values = DummyStationSource.getParkList();
        for (ContentValues v : values)
            getContext().getContentResolver().insert(mUri, v);

        getContext().getContentResolver().notifyChange(mUri, null);
        enableRefresh(false);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR_STATION);
    }

    @Override
    public void onParkSelect(String parkId) {
        Intent intent = new Intent(getContext(), ParkInfoActivity.class);
        intent.putExtra(ConstantDef.ARG_STRING, parkId);
        getActivity().startActivity(intent);
    }

    @Override
    public void onParkDelete(String parkId) {
        getContext().getContentResolver().delete(mUri, RoadProProvider.FIELD_ID + "=?", new String[]{parkId});
        getContext().getContentResolver().notifyChange(mUri, null);
    }
}
