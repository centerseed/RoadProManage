package com.moana.roadpro_manage.base;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moana.roadpro_manage.R;


public abstract class RecyclerFragment extends ContentFragment implements SwipeRefreshLayout.OnRefreshListener {
    protected SwipeRefreshLayout mSwipeRefresh;
    protected RecyclerView mRecycler;
    protected AbstractRecyclerCursorAdapter mAdapter;
    protected TextView mTitle;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recycler, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mSwipeRefresh = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh);
        mSwipeRefresh.setOnRefreshListener(this);
        mRecycler = (RecyclerView) view.findViewById(R.id.recycler);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecycler.setLayoutManager(manager);

        mAdapter = getAdapter();
        mRecycler.setAdapter(mAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mSwipeRefresh.setRefreshing(true);
        onSync();
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            mAdapter.swapCursor(data);
            mSwipeRefresh.setRefreshing(false);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }

    public void enableRefresh(boolean enable) {
        if (mSwipeRefresh != null)
            mSwipeRefresh.setRefreshing(enable);
    }

    abstract protected AbstractRecyclerCursorAdapter getAdapter();

    protected void hideTitle() {
        mTitle.setVisibility(View.GONE);
    }

    @Override
    public void onRefresh() {
        onSync();
    }

    protected abstract void onSync();
}
