package com.moana.roadpro_manage.car;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.moana.roadpro_manage.base.BasePagerActivity;
import com.moana.roadpro_manage.base.ConstantDef;


public class CarInfoActivity extends BasePagerActivity {

    String mCarNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCarNo = getIntent().getStringExtra(ConstantDef.ARG_STRING);
    }

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
                    return CarBasicFragment.getInstance(mCarNo);
                default:
                    return CarMaintainFragment.getInstance(mCarNo);
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
                    return "基本資料";
                case 1:
                    return "維修紀錄";
                case 2:
                    return "保養紀錄";
            }
            return "";
        }
    }
}
