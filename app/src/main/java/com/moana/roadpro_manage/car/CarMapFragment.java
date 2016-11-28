package com.moana.roadpro_manage.car;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.Loader;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.dummy.DummyCarSource;
import com.moana.roadpro_manage.map.ContentMapFragment;

import java.util.ArrayList;

public class CarMapFragment extends ContentMapFragment {
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR);
    }

    @Override
    public void onResume() {
        super.onResume();
        ArrayList<ContentValues> values = DummyCarSource.getCarData();
        for (ContentValues v : values)
            getContext().getContentResolver().insert(mUri, v);

        getContext().getContentResolver().notifyChange(mUri, null);
    }

    @Override
    protected void onInfoClick(Marker marker) {

    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst() && mMap != null) {
            mMap.clear();

            while (!data.isAfterLast()) {

                String carNO = data.getString(data.getColumnIndex(RoadProProvider.FIELD_CAR_NO));
                float lat = data.getFloat(data.getColumnIndex(RoadProProvider.FIELD_LAT));
                float lng = data.getFloat(data.getColumnIndex(RoadProProvider.FIELD_LNG));

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(lat, lng))
                        .snippet(carNO)
                        .icon(BitmapDescriptorFactory.fromBitmap(writeTextOnDrawable(R.mipmap.icon_s1map_cartag_green, carNO))));

                data.moveToNext();
            }
        }
    }
}
