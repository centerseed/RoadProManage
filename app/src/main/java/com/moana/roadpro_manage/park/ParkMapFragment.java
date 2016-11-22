package com.moana.roadpro_manage.park;

import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.support.v4.content.Loader;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.moana.roadpro_manage.map.ContentMapFragment;

public class ParkMapFragment extends ContentMapFragment implements OnMapReadyCallback {

    @Override
    protected Uri getProviderUri() {
        return null;
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

    }
}
