package com.moana.roadpro_manage.park;

import android.content.ContentValues;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.support.v4.content.Loader;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.dummy.DummyCarSource;
import com.moana.roadpro_manage.dummy.DummyStationSource;
import com.moana.roadpro_manage.map.BroadcastMap;
import com.moana.roadpro_manage.map.ContentMapFragment;

import java.util.ArrayList;

public class ParkMapFragment extends BroadcastMap implements OnMapReadyCallback {

    @Override
    protected Uri getProviderUri() {
        return RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR_STATION);
    }

    @Override
    public void onResume() {
        super.onResume();
       /* ArrayList<ContentValues> values = DummyStationSource.getParkList();
        for (ContentValues v : values)
            getContext().getContentResolver().insert(mUri, v);
*/
        getContext().getContentResolver().notifyChange(mUri, null);
    }

    @Override
    public void addIntentFilter(IntentFilter filter) {
        filter.addAction(ConstantDef.ACTION_MOVE_TO_POSITION);
    }

    @Override
    public void onReceiveBroadcast(String action, Intent intent) {
        if (ConstantDef.ACTION_MOVE_TO_POSITION.equals(action)) {
            LatLng latLng = intent.getParcelableExtra(ConstantDef.ARG_LATLNG);
            moveCamera(11, latLng);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        super.onMapReady(googleMap);

        moveToDummyPosition();
    }

    private void moveToDummyPosition() {
        LatLng location = new LatLng(22.6381039, 120.3032935);
        moveCamera(11.22f, location);
    }

    @Override
    protected void onInfoClick(Marker marker) {
        Intent intent = new Intent(getActivity(), ParkInfoActivity.class);
        String id = marker.getTitle().split(" - ")[1];
        intent.putExtra(ConstantDef.ARG_STRING, id);

        getActivity().startActivity(intent);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if (data != null && data.moveToFirst() && mMap != null) {
            mMap.clear();
            while (!data.isAfterLast()) {
                String id = data.getString(data.getColumnIndex(RoadProProvider.FIELD_ID));
                String name = data.getString(data.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_NAME));
                String address = data.getString(data.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_ADDRESS));
                float lat = data.getFloat(data.getColumnIndex(RoadProProvider.FIELD_LAT));
                float lng = data.getFloat(data.getColumnIndex(RoadProProvider.FIELD_LNG));

                mMap.addMarker(new MarkerOptions()
                        .position(new LatLng(lat, lng))
                        .title(name + " - " + id)
                        .snippet(address)
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.icon_parking_cartag)));

                data.moveToNext();
            }
        }
    }
}
