package com.moana.roadpro_manage.curing;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.RecyclerFragment;
import com.moana.roadpro_manage.dummy.DummyCuringSource;

import java.util.ArrayList;

public class CuringMaintainFragment extends RecyclerFragment {
    @Override
    protected AbstractRecyclerCursorAdapter getAdapter() {
        return new CuringAdapter(getContext(), null);
    }

    @Override
    protected void onSync() {
        mRecycler.postDelayed(new Thread(new Runnable() {

            @Override
            public void run() {
                ArrayList<ContentValues> values = DummyCuringSource.getMaintainData();
                for (ContentValues v : values) {
                    getContext().getContentResolver().insert(mUri, v);
                }

                getContext().getContentResolver().notifyChange(mUri, null);
                enableRefresh(false);
            }
        }), 500);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = (CursorLoader) super.onCreateLoader(id, args);
        cl.setSelection(RoadProProvider.FIELD_MAINTAIN_ITEM + "=?");
        cl.setSelectionArgs(new String[]{"maintain"});
        return cl;
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
