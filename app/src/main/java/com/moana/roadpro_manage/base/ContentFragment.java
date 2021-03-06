package com.moana.roadpro_manage.base;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.View;

public abstract class ContentFragment extends ActionBarFragment implements LoaderManager.LoaderCallbacks<Cursor> {
    protected Uri mUri;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUri = getProviderUri();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mUri != null)
            getLoaderManager().initLoader(0, null, this);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mUri != null)
            getLoaderManager().destroyLoader(0);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = new CursorLoader(getActivity());
        cl.setUri(mUri);
        return cl;
    }

    abstract protected Uri getProviderUri();
}