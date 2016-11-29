package com.moana.roadpro_manage.plug;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.moana.roadpro_manage.base.BasePagerFragment;
import com.moana.roadpro_manage.car.report.ProperRateFragment;
import com.moana.roadpro_manage.car.report.RepairRecordFragment;

public class PlugReportFragment extends BasePagerFragment {
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
                    return new PlugUsageOrderFragment();
                default:
                    return new ProperRateFragment();
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
                    return "使用記錄";
                case 1:
                    return "營收報表";
            }
            return "";
        }
    }

    @Override
    protected String getActionBarTitle() {
        return "充電站綜合報表";
    }
}
