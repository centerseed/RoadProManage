package com.moana.roadpro_manage.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moana.roadpro_manage.R;


public abstract class BasePagerFragment extends Fragment {
    protected ViewPager mViewPager;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_base_pager, container, false);
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentPagerAdapter sectionsPagerAdapter = getPagerAdapter(getFragmentManager());

        mViewPager = (ViewPager) view.findViewById(R.id.container);
        mViewPager.setAdapter(sectionsPagerAdapter);
    }

    protected abstract FragmentPagerAdapter getPagerAdapter(FragmentManager fm);
}
