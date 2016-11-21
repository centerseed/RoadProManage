package com.moana.roadpro_manage.curing;

import android.net.Uri;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.RecyclerFragment;

public class CuringRepairFragment extends RecyclerFragment {
    @Override
    protected AbstractRecyclerCursorAdapter getAdapter() {
        return new CuringAdapter(getContext(), null);
    }

    @Override
    protected void onSync() {
        enableRefresh(false);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_MAINTAIN);
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }
}
