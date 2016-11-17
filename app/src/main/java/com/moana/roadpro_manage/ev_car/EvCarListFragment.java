package com.moana.roadpro_manage.ev_car;

import android.net.Uri;

import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.RecyclerFragment;

public class EvCarListFragment extends RecyclerFragment{
    @Override
    protected AbstractRecyclerCursorAdapter getAdapter() {
        return null;
    }

    @Override
    protected String getTitle() {
        return "車輛清單";
    }

    @Override
    protected void onSync() {

    }

    @Override
    protected Uri getProviderUri() {
        return null;
    }
}
