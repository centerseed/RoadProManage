package com.moana.roadpro_manage.car;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.moana.roadpro_manage.base.BasePagerActivity;
import com.moana.roadpro_manage.base.ConstantDef;

public class CarMaintainActivity extends BasePagerActivity {
    String mCarNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCarNo = getIntent().getStringExtra(ConstantDef.ARG_STRING);
    }

    @Override
    public String getToolbarTitle() {
        return "車輛養護";
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
                    return "車輛維修";
                case 1:
                    return "車輛保養";
                case 2:
                    return "車輛清潔";
            }
            return "";
        }
    }
}
