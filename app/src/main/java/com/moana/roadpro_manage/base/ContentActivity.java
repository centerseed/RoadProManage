package com.moana.roadpro_manage.base;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;

public abstract class ContentActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    protected Uri mUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUri = getProviderUri();

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        if (mUri != null)
            getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getSupportLoaderManager().restartLoader(0, null, this);
    }
/*
    @Override
    protected void onPause() {
        super.onPause();
        if (mUri != null)
            getLoaderManager().destroyLoader(0);
    }
*/
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = new CursorLoader(this);
        cl.setUri(mUri);
        return cl;
    }

    abstract protected Uri getProviderUri();
}
