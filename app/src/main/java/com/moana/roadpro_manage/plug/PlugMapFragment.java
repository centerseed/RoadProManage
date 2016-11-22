package com.moana.roadpro_manage.plug;

import android.content.ContentValues;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.support.v4.content.Loader;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.dummy.DummyStationSource;
import com.moana.roadpro_manage.map.ContentMapFragment;

import java.util.ArrayList;

public class PlugMapFragment extends ContentMapFragment implements OnMapReadyCallback {

    @Override
    public void onResume() {
        super.onResume();

        getContext().getContentResolver().delete(mUri, RoadProProvider.FIELD_ID + "!=?", new String[]{"0"});

        ArrayList<ContentValues> list = DummyStationSource.getPlugList();
        for (ContentValues values : list) {
            getContext().getContentResolver().insert(mUri, values);
        }
        getContext().getContentResolver().notifyChange(mUri, null);
    }

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_PLUG_STATION);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);

        moveToDummyPosition();
    }

    private void moveToDummyPosition() {
        Location location = new Location("");
        location.setLatitude(23.6000634);
        location.setLongitude(120.982024);
        moveCamera(7.62f, location);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst() && mMap != null) {
            mMap.clear();

            while (!data.isAfterLast()) {

                String id = data.getString(data.getColumnIndex(RoadProProvider.FIELD_ID));
                String name = data.getString(data.getColumnIndex(RoadProProvider.FIELD_PLUG_STATION_NAME));
                String address = data.getString(data.getColumnIndex(RoadProProvider.FIELD_PLUG_STATION_ADDRESS));
                float lat = data.getFloat(data.getColumnIndex(RoadProProvider.FIELD_LAT));
                float lng = data.getFloat(data.getColumnIndex(RoadProProvider.FIELD_LNG));

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(lat, lng))
                        .title(name + " - " + id)
                        .snippet(address)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.icon_charge_evtag)));

                data.moveToNext();
            }
        }
    }
}
