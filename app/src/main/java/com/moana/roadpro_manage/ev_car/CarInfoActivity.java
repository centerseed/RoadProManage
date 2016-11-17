package com.moana.roadpro_manage.ev_car;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.moana.roadpro_manage.base.BasePagerActivity;


public class CarInfoActivity extends BasePagerActivity {
    @Override
    public String getToolbarTitle() {
        return "車輛資訊";
    }

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
                    return new CarBasicFragment();
                default:
                    return new CarBasicFragment();
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
                    return "基本資料";
                case 1:
                    return "維修紀錄";
            }
            return "";
        }
    }
}
