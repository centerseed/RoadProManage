package com.moana.roadpro_manage.park;

import android.app.Dialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.RecyclerFragment;

public class RentCountListFragment extends RecyclerFragment {

    final CharSequence[] items = { "日", "月", "年" };
    int mSelect = 0;

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_order, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_order:
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
        enableRefresh(false);
    }

    @Override
    protected Uri getProviderUri() {
        // use other table for dummy data
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR);
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
