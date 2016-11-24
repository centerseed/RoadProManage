package com.moana.roadpro_manage.plug;

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
import com.moana.roadpro_manage.dummy.DummyCarSource;
import com.moana.roadpro_manage.dummy.DummyStationSource;
import com.moana.roadpro_manage.park.ParkAdapter;
import com.moana.roadpro_manage.park.ParkEditInfoActivity;
import com.moana.roadpro_manage.park.ParkInfoActivity;

import java.util.ArrayList;

public class PlugListFragment extends RecyclerFragment implements PlugAdapter.PlugClickListener {
    @Override
    protected AbstractRecyclerCursorAdapter getAdapter() {
        return new PlugAdapter(getContext(), null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((PlugAdapter) mAdapter).setParkClickListener(this);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_parklist, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_add_park:
                Intent intent = new Intent(getActivity(), PlugEditInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.action_delete:
                ((PlugAdapter) mAdapter).toggleDelete();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSync() {
        // Skip parser
        getContext().getContentResolver().delete(mUri, RoadProProvider.FIELD_ID + "!=?", new String[]{"0"});

        ArrayList<ContentValues> values = DummyStationSource.getPlugList();
        for (ContentValues v : values)
            getContext().getContentResolver().insert(mUri, v);

        getContext().getContentResolver().notifyChange(mUri, null);
        enableRefresh(false);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_PLUG_STATION);
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }

    @Override
    public void onPlugSelect(String parkId) {
        Intent intent = new Intent(getContext(), PlugInfoActivity.class);
        intent.putExtra(ConstantDef.ARG_STRING, parkId);
        getActivity().startActivity(intent);
    }

    @Override
    public void onPlugDelete(String parkId) {
        getContext().getContentResolver().delete(mUri, RoadProProvider.FIELD_ID + "=?", new String[]{parkId});
        getContext().getContentResolver().notifyChange(mUri, null);
    }
}
