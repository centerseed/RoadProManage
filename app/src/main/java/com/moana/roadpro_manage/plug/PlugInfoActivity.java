package com.moana.roadpro_manage.plug;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.base.ContentActivity;
import com.squareup.picasso.Picasso;

public class PlugInfoActivity extends ContentActivity {

    ImageView mPark;
    TextView mName;
    TextView mAddress;
    String mPlugID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("充電站資訊");

        mPlugID = getIntent().getStringExtra(ConstantDef.ARG_STRING);

        mPark = (ImageView) findViewById(R.id.park_img);
        mName = (TextView) findViewById(R.id.name);
        mAddress = (TextView) findViewById(R.id.address);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_PLUG_STATION);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cl = (CursorLoader) super.onCreateLoader(id, args);
        cl.setSelection(RoadProProvider.FIELD_ID + "=?");
        cl.setSelectionArgs(new String[]{mPlugID});
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
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
