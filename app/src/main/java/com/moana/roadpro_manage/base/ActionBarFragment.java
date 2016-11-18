package com.moana.roadpro_manage.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public abstract class ActionBarFragment extends Fragment {
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    protected ActionBar mToolbar;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);

        try {
            mToolbar = ((AppCompatActivity) getActivity()).getSupportActionBar();
            if (getActionBarTitle() != null) {
                ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(getActionBarTitle());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected abstract String getActionBarTitle();
}
