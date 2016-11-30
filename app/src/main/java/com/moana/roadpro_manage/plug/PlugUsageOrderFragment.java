package com.moana.roadpro_manage.plug;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.DatePicker;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.base.RecyclerFragment;
import com.moana.roadpro_manage.dummy.DummyPlugSource;
import com.moana.roadpro_manage.utils.PickerUtils;

public class PlugUsageOrderFragment extends RecyclerFragment implements PlugUsageAdapter.PlugUsageListener {

    final CharSequence[] items = {"日", "月", "年"};
    int mSelect = 0;

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = (CursorLoader) super.onCreateLoader(id, args);
        cl.setSortOrder(RoadProProvider.FIELD_PLUG_USAGE + " DESC");
        return cl;
    }

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
        PlugUsageAdapter adapter = new PlugUsageAdapter(getContext(), null);
        adapter.setOnClickListener(this);
        return adapter;
    }

    @Override
    protected void onSync() {
        mRecycler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ContentResolver resolver = getContext().getContentResolver();
                resolver.delete(mUri, RoadProProvider.FIELD_ID + "!=?", new String[]{"0"});
                for (ContentValues v : DummyPlugSource.getPlugDayReportData(1472688000)) {
                    resolver.insert(mUri, v);
                }
                enableRefresh(false);
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

                        if (item == 0) {
                            PickerUtils.showDatePicker(getContext(), new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                                }
                            });
                        }
                        if (item == 1) {
                            PickerUtils.showMonthPicker(getFragmentManager(), new DatePickerDialog.OnDateSetListener() {
                                @Override
                                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                                }
                            });
                        } else if (item == 2) {
                            PickerUtils.showYearPicker(getContext(), new PickerUtils.YearPickerListener() {
                                @Override
                                public void onYearSelected(int year) {

                                }
                            });
                        }
                    }
                });
        Dialog levelDialog = builder.create();
        levelDialog.show();
    }

    @Override
    public void onPlugSelected(String id) {
        Intent intent = new Intent(getActivity(), PlugReportActivity.class);
        intent.putExtra(ConstantDef.ARG_STRING, id);
        startActivity(intent);
    }
}
