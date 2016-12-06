package com.moana.roadpro_manage.park;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageView;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.base.ContentActivity;
import com.squareup.picasso.Picasso;

public class ParkEditInfoActivity extends ContentActivity {

    ImageView mPark;
    EditText mName;
    EditText mAddress;
    String mParkID;
    int mParkId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_park_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("停車場資訊");

        mParkID = getIntent().getStringExtra(ConstantDef.ARG_STRING);

        if (mParkID == null) {
            getSupportActionBar().setTitle("新增停車場");
        } else {
            getSupportActionBar().setTitle("修改停車場資訊");
        }

        mPark = (ImageView) findViewById(R.id.park_img);
        mName = (EditText) findViewById(R.id.name);
        mAddress = (EditText) findViewById(R.id.address);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR_STATION);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_done, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_done) {
            // TODO: add park here
            saveParkInfo();
            finish();
        }

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = (CursorLoader) super.onCreateLoader(id, args);
        cl.setSelection(RoadProProvider.FIELD_ID + "=?");
        if (mParkID != null) {
            cl.setSelectionArgs(new String[]{mParkID});
        } else {
            cl.setSelectionArgs(new String[]{""});
        }
        return cl;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            String url = data.getString(data.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_PHOTO));
            if (url != null && url.length() > 0)
                Picasso.with(this).load(url).into(mPark);

            mName.setText(data.getString(data.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_NAME)));
            mAddress.setText(data.getString(data.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_ADDRESS)));
            mParkId = data.getInt(data.getColumnIndex(RoadProProvider.FIELD_ID));
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void saveParkInfo() {
        ContentValues values = new ContentValues();
        if (mParkId != 0)
            values.put(RoadProProvider.FIELD_ID, mParkId);
        else
            values.put(RoadProProvider.FIELD_ID, mName.getText().toString().hashCode());
        values.put(RoadProProvider.FIELD_CAR_STATION_NAME, mName.getText().toString());
        values.put(RoadProProvider.FIELD_CAR_STATION_ADDRESS, mAddress.getText().toString());

        getContentResolver().insert(mUri, values);
        getContentResolver().notifyChange(mUri, null);
    }
}
