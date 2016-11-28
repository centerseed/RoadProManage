package com.moana.roadpro_manage.park;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.moana.roadpro_manage.ParkSearchResultAdapter;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.BasePagerFragment;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.base.SearchPagerFragment;

public class ParkFragment extends SearchPagerFragment implements ParkSearchResultAdapter.ResultAdapterListener {

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected FragmentPagerAdapter getPagerAdapter(FragmentManager fm) {
        return new SectionsPagerAdapter(fm);
    }

    @Override
    protected AbstractRecyclerCursorAdapter getSearchAdapter() {
        ParkSearchResultAdapter adapter = new ParkSearchResultAdapter(getContext(), null);
        adapter.setSiteSearchResultAdapterListener(this);
        return adapter;
    }

    @Override
    protected String getActionBarTitle() {
        return "停車場查詢";
    }

    @Override
    public Uri getUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR_STATION);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = (CursorLoader) super.onCreateLoader(id, args);
        cl.setSelection(" (" + RoadProProvider.FIELD_CAR_STATION_ADDRESS + " like '%" + mSearchText + "%' or " + RoadProProvider.FIELD_CAR_STATION_NAME + " like '%" + mSearchText + "%')");
        return cl;
    }

    @Override
    public void onResultClick(String snippet) {
        Intent intent = new Intent();
        intent.setAction(ConstantDef.ACTION_MOVE_TO_POSITION);
        intent.putExtra(ConstantDef.ARG_STRING, snippet);
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);

        mSearchText = "";
        mSearchView.onActionViewCollapsed();
        mSearchResultList.setVisibility(View.GONE);
    }


    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ParkMapFragment();
                default:
                    return new ParkListFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "地圖";
                case 1:
                    return "列表";
            }
            return "";
        }
    }
}
