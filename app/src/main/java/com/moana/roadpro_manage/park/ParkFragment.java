package com.moana.roadpro_manage.park;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Menu;
import android.view.MenuInflater;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.BasePagerFragment;
import com.moana.roadpro_manage.ev_car.report.ProperRateFragment;
import com.moana.roadpro_manage.ev_car.report.RepairRecordFragment;

public class ParkFragment extends BasePagerFragment {

    @Override
    protected FragmentPagerAdapter getPagerAdapter(FragmentManager fm) {
        return new SectionsPagerAdapter(fm);
    }

    @Override
    protected String getActionBarTitle() {
        return "停車場查詢";
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ParkMapFragment();
                default:
                    return new ParkListFragment();
            }
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "地圖";
                case 1:
                    return "列表";
            }
            return "";
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_park, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }
}
