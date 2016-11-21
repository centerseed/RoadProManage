package com.moana.roadpro_manage.park;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.moana.roadpro_manage.base.BasePagerFragment;
import com.moana.roadpro_manage.curing.CuringRepairFragment;

public class ParkReportFragment extends BasePagerFragment {
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
                    return new RentCountListFragment();
                case 1:
                    return new TurnoverFragment();
                default:
                    return new UseCountChartFragment();
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
                    return "租借數量";
                case 1:
                    return "週轉率";
                case 2:
                    return "使用車次";
            }
            return "";
        }
    }

    @Override
    protected String getActionBarTitle() {
        return "停車場報表";
    }
}
