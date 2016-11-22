package com.moana.roadpro_manage.ev_car;

import android.database.Cursor;
import android.net.Uri;
import android.support.v4.content.Loader;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.ContentMapFragment;

public class CarMapFragment extends ContentMapFragment {
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR);
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
