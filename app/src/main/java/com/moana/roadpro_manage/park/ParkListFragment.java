package com.moana.roadpro_manage.park;

import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.base.RecyclerFragment;
import com.moana.roadpro_manage.dummy.DummyStationSource;

import java.util.ArrayList;

public class ParkListFragment extends RecyclerFragment implements ParkAdapter.ParkClickListener {

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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_parklist, menu);
        super.onCreateOptionsMenu(menu, inflater);
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
    protected String getActionBarTitle() {
        return null;
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
