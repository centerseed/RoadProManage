package com.moana.roadpro_manage.plug;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.BasePagerActivity;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.car.CarBasicFragment;
import com.moana.roadpro_manage.car.CarMaintainFragment;


public class PlugReportActivity extends BasePagerActivity {

    String mPlugId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlugId = getIntent().getStringExtra(ConstantDef.ARG_STRING);
    }

    @Override
    public String getToolbarTitle() {
        return "充電站報表";
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
                    return new UsageCountFragment();
                default:
                    return CarMaintainFragment.getInstance(mPlugId);
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
}
