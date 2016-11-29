package com.moana.roadpro_manage.plug;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.RecyclerFragment;
import com.moana.roadpro_manage.dummy.DummyPlugSource;
import com.moana.roadpro_manage.park.ParkEditInfoActivity;

import java.util.ArrayList;

public class PlugUsageOrderFragment extends RecyclerFragment {

    final CharSequence[] items = {"日", "月", "年"};
    int mSelect = 0;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_date, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case R.id.action_date:
                showSelectedDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected AbstractRecyclerCursorAdapter getAdapter() {
        return new PlugUsageAdapter(getContext(), null);
    }

    @Override
    protected void onSync() {
        mRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ContentResolver resolver = getContext().getContentResolver();
                resolver.delete(mUri, RoadProProvider.FIELD_ID + "!=?", new String[]{"0"});
                ArrayList<ContentValues> values = DummyPlugSource.getPlugDayReportData();
                for (ContentValues v : values) {
                    resolver.insert(mUri, v);
                }
                resolver.notifyChange(mUri, null);
            }
        }, 1000);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_PLUG_REPORT);
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
