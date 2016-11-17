package com.moana.roadpro_manage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.moana.roadpro_manage.ev_car.IntroduceFragment;

public class HomeFragment extends Fragment {

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

    class OnFuncClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Fragment f = null;
            switch (view.getId()) {
                case R.id.ev_car:
                    f = new IntroduceFragment();
                    break;
                case R.id.park:
                    break;
                case R.id.plug:
                    break;
            }

            if (f != null) {
                getFragmentManager().beginTransaction().replace(R.id.container, f).commit();
            }
        }
    }
}
