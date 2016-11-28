package com.moana.roadpro_manage.base;


import android.app.SearchManager;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.moana.roadpro_manage.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

abstract public class SearchPagerFragment extends ActionBarFragment implements SearchView.OnQueryTextListener, LoaderManager.LoaderCallbacks<Cursor> {

    protected Uri mUri;
    protected String mSearchText;
    protected ViewPager mViewPager;
    SmartTabLayout viewPagerTab;
    protected SearchView mSearchView;
    protected RecyclerView mSearchResultList;
    protected AbstractRecyclerCursorAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mUri = getUri();
        mAdapter = getSearchAdapter();

        mViewPager = (ViewPager) view.findViewById(R.id.fragment_pager);
        viewPagerTab = (SmartTabLayout) view.findViewById(R.id.viewpagertab);

        FragmentPagerAdapter sectionsPagerAdapter = getPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(sectionsPagerAdapter);
        viewPagerTab.setViewPager(mViewPager);
        sectionsPagerAdapter.notifyDataSetChanged();

        mSearchResultList = (RecyclerView) view.findViewById(R.id.search_result);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mSearchResultList.setLayoutManager(manager);
        mSearchResultList.setAdapter(mAdapter);
        mSearchResultList.setVisibility(View.GONE);
    }

    @Override
    public void onResume() {
        super.onResume();

        getLoaderManager().initLoader(0, null, this);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_search, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) getContext().getSystemService(Context.SEARCH_SERVICE);

        if (searchItem != null) {
             mSearchView = (SearchView) searchItem.getActionView();
        }
        if (mSearchView != null) {
            mSearchView.setOnQueryTextListener(this);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        if (newText.length() > 0) {
            mSearchText = newText;
            getLoaderManager().restartLoader(0, null, this);
            mSearchResultList.setVisibility(View.VISIBLE);
        } else {
            mSearchResultList.setVisibility(View.GONE);
        }
        return false;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = new CursorLoader(getActivity());
        cl.setUri(mUri);
        return cl;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            mAdapter.swapCursor(data);
        } else {
            mAdapter.swapCursor(null);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    public abstract Uri getUri();

    @Override
    protected String getActionBarTitle() {
        return null;
    }

    protected abstract FragmentPagerAdapter getPagerAdapter(FragmentManager fm);
    protected abstract AbstractRecyclerCursorAdapter getSearchAdapter();
}
