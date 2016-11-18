package com.moana.roadpro_manage.ev_car;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.ContentFragment;
import com.moana.roadpro_manage.base.ContentMapFragment;
import com.moana.roadpro_manage.map.MapsFragment;

public class IntroduceFragment extends ContentFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_introduce, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Fragment f = new ContentMapFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, f).commit();
    }

    @Override
    protected String getActionBarTitle() {
        return "業者介紹";
    }

    @Override
    protected Uri getProviderUri() {
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
