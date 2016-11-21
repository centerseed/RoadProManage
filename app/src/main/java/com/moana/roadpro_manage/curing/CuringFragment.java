package com.moana.roadpro_manage.curing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.moana.roadpro_manage.base.BasePagerFragment;
import com.moana.roadpro_manage.ev_car.CarBasicFragment;
import com.moana.roadpro_manage.park.ParkMapFragment;

public class CuringFragment extends BasePagerFragment {
    @Override
    protected FragmentPagerAdapter getPagerAdapter(FragmentManager fm) {
        return new SectionsPagerAdapter(fm);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new CuringRepairFragment();
                default:
                    return new CuringRepairFragment();
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "車輛維修";
                case 1:
                    return "車輛保養";
                case 2:
                    return "車輛清潔";
            }
            return "";
        }
    }

    @Override
    protected String getActionBarTitle() {
        return "車輛養護";
    }
}
