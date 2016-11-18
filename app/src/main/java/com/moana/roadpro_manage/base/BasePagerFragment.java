package com.moana.roadpro_manage.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moana.roadpro_manage.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;


public abstract class BasePagerFragment extends Fragment {
    protected ViewPager mViewPager;
    SmartTabLayout viewPagerTab;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base_pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mViewPager = (ViewPager) view.findViewById(R.id.fragment_pager);
        viewPagerTab = (SmartTabLayout) view.findViewById(R.id.viewpagertab);
    }

    @Override
    public void onResume() {
        super.onResume();
        FragmentPagerAdapter sectionsPagerAdapter = getPagerAdapter(getChildFragmentManager());
        mViewPager.setAdapter(sectionsPagerAdapter);
        viewPagerTab.setViewPager(mViewPager);
        sectionsPagerAdapter.notifyDataSetChanged();

    }

    protected abstract String getToolbarTitle();

    protected abstract FragmentPagerAdapter getPagerAdapter(FragmentManager fm);
}
