package com.moana.roadpro_manage.park;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.RecyclerFragment;
import com.moana.roadpro_manage.dummy.DummyParkSource;

import java.util.ArrayList;

public class RentCountListFragment extends RecyclerFragment {

    final CharSequence[] items = { "日", "月", "年" };
    int mSelect = 0;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_date, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_date:
                showSelectedDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected AbstractRecyclerCursorAdapter getAdapter() {
        return new RentCountAdapter(getContext(), null);
    }

    @Override
    protected void onSync() {
        ContentResolver resolver = getContext().getContentResolver();
        ArrayList<ContentValues> values = DummyParkSource.getParkDayReportData(1472688000);
        for (ContentValues v : values) {
            resolver.insert(mUri, v);
        }
        resolver.notifyChange(mUri, null);
        enableRefresh(false);
    }

    @Override
    protected Uri getProviderUri() {
        // use other table for dummy data
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR_REPORT);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = (CursorLoader) super.onCreateLoader(id, args);
        cl.setSortOrder(RoadProProvider.FIELD_CAR_REPORT_RENT_COUNT + " DESC");
        return cl;
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }

    private void showSelectedDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("選擇日期區間");

        builder.setSingleChoiceItems(items, mSelect,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        mSelect = item;
                        dialog.dismiss();
                    }
                });
        Dialog levelDialog = builder.create();
        levelDialog.show();
    }
}
