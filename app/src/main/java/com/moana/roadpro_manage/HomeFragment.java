package com.moana.roadpro_manage;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.moana.roadpro_manage.base.ActionBarFragment;
import com.moana.roadpro_manage.car.CarStatusFragment;
import com.moana.roadpro_manage.park.ParkFragment;
import com.moana.roadpro_manage.plug.PlugFragment;

public class HomeFragment extends ActionBarFragment {

    ImageView mEvCar;
    ImageView mPark;
    ImageView mPlug;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mEvCar = (ImageView) view.findViewById(R.id.ev_car);
        mPark = (ImageView) view.findViewById(R.id.park);
        mPlug = (ImageView) view.findViewById(R.id.plug);

        OnFuncClickListener listener = new OnFuncClickListener();
        mEvCar.setOnClickListener(listener);
        mPark.setOnClickListener(listener);
        mPlug.setOnClickListener(listener);
    }

    @Override
    protected String getActionBarTitle() {
        return null;
    }


    class OnFuncClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Fragment f = null;
            mToolbar.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.colorPrimary)));
            mToolbar.setHomeAsUpIndicator(R.mipmap.ic_menu_white_24dp);
            mToolbar.setDisplayHomeAsUpEnabled(true);
            switch (view.getId()) {
                case R.id.ev_car:
                    f = new CarStatusFragment();
                    break;
                case R.id.park:
                    f = new ParkFragment();
                    break;
                case R.id.plug:
                    f = new PlugFragment();
                    break;
            }

            if (f != null) {
                getFragmentManager().beginTransaction().replace(R.id.container, f).commit();
            }
        }
    }
}
