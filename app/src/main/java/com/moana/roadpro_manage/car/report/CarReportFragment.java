package com.moana.roadpro_manage.car.report;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Menu;
import android.view.MenuInflater;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.BasePagerFragment;

public class CarReportFragment extends BasePagerFragment {

    @Override
    protected FragmentPagerAdapter getPagerAdapter(FragmentManager fm) {
        return new SectionsPagerAdapter(fm);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // inflater.inflate(R.menu.menu_report, menu);
        super.onCreateOptionsMenu(menu,inflater);
    }

    @Override
    protected String getActionBarTitle() {
        return "管理報表";
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new RepairRecordFragment();
                case 1:
                    return new ProperRateFragment();
                default:
                    return new ProperRateFragment();
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
                    return "故障紀錄";
                case 1:
                    return "營運妥善率";
                case 2:
                    return "用電效率";
            }
            return "";
        }
    }
}
