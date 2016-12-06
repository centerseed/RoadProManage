package com.moana.roadpro_manage.plug;

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

public class PlugEditInfoActivity extends ContentActivity {

    ImageView mPark;
    EditText mName;
    EditText mAddress;
    EditText mSerial;
    String mPlugID;
    int mPlugId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_plug_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPlugID = getIntent().getStringExtra(ConstantDef.ARG_STRING);

        mSerial = (EditText) findViewById(R.id.serial);

        if (mPlugID == null) {
            getSupportActionBar().setTitle("新增充電樁");
        } else {
            getSupportActionBar().setTitle("修改充電樁資訊");
            mSerial.setEnabled(false);
        }

        mPark = (ImageView) findViewById(R.id.park_img);
        mName = (EditText) findViewById(R.id.name);
        mAddress = (EditText) findViewById(R.id.address);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_PLUG_STATION);
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
            savePlugInfo();
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
        if (mPlugID != null) {
            cl.setSelectionArgs(new String[]{mPlugID});
        } else {
            cl.setSelectionArgs(new String[]{""});
        }
        return cl;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst()) {
            String url = data.getString(data.getColumnIndex(RoadProProvider.FIELD_PLUG_STATION_PHOTO));
            if (url != null && url.length() > 0)
                Picasso.with(this).load(url).into(mPark);

            mName.setText(data.getString(data.getColumnIndex(RoadProProvider.FIELD_PLUG_STATION_NAME)));
            mAddress.setText(data.getString(data.getColumnIndex(RoadProProvider.FIELD_PLUG_STATION_ADDRESS)));

            mPlugId = data.getInt(data.getColumnIndex(RoadProProvider.FIELD_ID));
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private void savePlugInfo() {
        ContentValues values = new ContentValues();
        if (mPlugId != 0)
            values.put(RoadProProvider.FIELD_ID, mPlugId);
        else
            values.put(RoadProProvider.FIELD_ID, mName.getText().toString().hashCode());
        values.put(RoadProProvider.FIELD_PLUG_STATION_NAME, mName.getText().toString());
        values.put(RoadProProvider.FIELD_PLUG_STATION_ADDRESS, mAddress.getText().toString());

        getContentResolver().insert(mUri, values);
        getContentResolver().notifyChange(mUri, null);
    }
}
