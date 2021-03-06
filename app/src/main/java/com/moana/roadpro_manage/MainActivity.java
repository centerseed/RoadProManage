package com.moana.roadpro_manage;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.moana.roadpro_manage.car.CarListFragment;
import com.moana.roadpro_manage.car.CarStatusFragment;
import com.moana.roadpro_manage.car.report.CarReportFragment;
import com.moana.roadpro_manage.curing.CuringFragment;
import com.moana.roadpro_manage.dummy.DummyCarSource;
import com.moana.roadpro_manage.dummy.DummyStationSource;
import com.moana.roadpro_manage.park.ParkFragment;
import com.moana.roadpro_manage.park.ParkReportFragment;
import com.moana.roadpro_manage.plug.PlugFragment;
import com.moana.roadpro_manage.plug.PlugReportFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    LinearLayout mListEvCar;
    LinearLayout mListCar;
    LinearLayout mListPlug;

    LinearLayout mItemCarActivity;
    LinearLayout mItemCarList;
    LinearLayout mItemCarMaintain;
    LinearLayout mItemCarManageReport;
    LinearLayout mItemParkSearch;
    LinearLayout mItemParkManage;
    LinearLayout mItemParkReport;
    LinearLayout mItemPlugActivity;
    LinearLayout mItemPlugManage;
    LinearLayout mItemPlugReport;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        initDrawerHeader(navigationView);

        mToolbar.setNavigationIcon(R.mipmap.ic_menu_black_24dp);
        Fragment f = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, f, "home").commit();

        dummySync();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (getSupportFragmentManager().findFragmentByTag("home") != null)
                super.onBackPressed();
            else {
                mToolbar.setNavigationIcon(R.mipmap.ic_menu_black_24dp);
                mToolbar.setBackgroundColor(Color.TRANSPARENT);
                mToolbar.setTitle("");
                Fragment f = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f, "home").commit();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void collapseAllList() {
        mListEvCar.setVisibility(View.GONE);
        mListCar.setVisibility(View.GONE);
        mListPlug.setVisibility(View.GONE);
    }

    class DrawerClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Log.e("Drawer Click", "view id -> " + view.getId());
            mToolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            mToolbar.setNavigationIcon(R.mipmap.ic_menu_white_24dp);

            Fragment f = null;

            switch (view.getId()) {
                // Layer 2
                case R.id.car_activity:
                    f = new CarStatusFragment();
                    break;
                case R.id.car_list:
                    f = new CarListFragment();
                    break;
                case R.id.car_curing:
                    f = new CuringFragment();
                    break;
                case R.id.car_manage_report:
                    f = new CarReportFragment();
                    break;
                case R.id.park_search:
                    f = new ParkFragment();
                    break;
                case R.id.park_report:
                    f = new ParkReportFragment();
                    break;
                case R.id.plug_search:
                    f = new PlugFragment();
                    break;
                case R.id.plug_report:
                    f = new PlugReportFragment();
                    break;
            }

            if (f != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f).commit();
            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }
    }

    private void initDrawerHeader(NavigationView navigationView) {
        View headerView = navigationView.getHeaderView(0);
        RadioGroup group = (RadioGroup) headerView.findViewById(R.id.group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                // collapseAllList();
                switch (i) {
                    // Layer 1
                    case R.id.ev_car_manage:
                        mListEvCar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.car_manage_system:
                        mListCar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.plug_manage_system:
                        mListPlug.setVisibility(View.VISIBLE);
                        break;
                    // Layer 2

                    // Layer 3
                }
            }
        });

        DrawerClickListener drawerClickListener = new DrawerClickListener();
        group.setOnClickListener(drawerClickListener);

        mListEvCar = (LinearLayout) headerView.findViewById(R.id.list_ev_car);
        mListCar = (LinearLayout) headerView.findViewById(R.id.list_car);
        mListPlug = (LinearLayout) headerView.findViewById(R.id.list_plug);

        mItemCarActivity = (LinearLayout) headerView.findViewById(R.id.car_activity);
        mItemCarList = (LinearLayout) headerView.findViewById(R.id.car_list);
        mItemCarMaintain = (LinearLayout) headerView.findViewById(R.id.car_curing);
        mItemCarManageReport = (LinearLayout) headerView.findViewById(R.id.car_manage_report);
        mItemParkSearch = (LinearLayout) headerView.findViewById(R.id.park_search);
        mItemParkManage = (LinearLayout) headerView.findViewById(R.id.park_manage);
        mItemParkReport = (LinearLayout) headerView.findViewById(R.id.park_report);
        mItemPlugActivity = (LinearLayout) headerView.findViewById(R.id.plug_search);
        mItemPlugManage = (LinearLayout) headerView.findViewById(R.id.plug_manage);
        mItemPlugReport = (LinearLayout) headerView.findViewById(R.id.plug_report);

        mItemCarActivity.setOnClickListener(drawerClickListener);
        mItemCarList.setOnClickListener(drawerClickListener);
        mItemCarMaintain.setOnClickListener(drawerClickListener);
        mItemCarManageReport.setOnClickListener(drawerClickListener);
        mItemParkSearch.setOnClickListener(drawerClickListener);
        mItemParkManage.setOnClickListener(drawerClickListener);
        mItemParkReport.setOnClickListener(drawerClickListener);
        mItemPlugActivity.setOnClickListener(drawerClickListener);
        mItemPlugManage.setOnClickListener(drawerClickListener);
        mItemPlugReport.setOnClickListener(drawerClickListener);

        Button logout = (Button) headerView.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    private void dummySync() {
        Uri parkUri = RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR_STATION);
        getContentResolver().delete(parkUri, RoadProProvider.FIELD_ID + "!=0", null);
        ArrayList<ContentValues> values = DummyStationSource.getParkList();
        for (ContentValues v : values)
            getContentResolver().insert(parkUri, v);
        getContentResolver().notifyChange(parkUri, null);

        Uri plugUri = RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_PLUG_STATION);
        getContentResolver().delete(plugUri, RoadProProvider.FIELD_ID + "!=0", null);
        ArrayList<ContentValues> plugValues = DummyStationSource.getPlugList();
        for (ContentValues v : plugValues)
            getContentResolver().insert(plugUri, v);
        getContentResolver().notifyChange(plugUri, null);

        Uri carUri = RoadProProvider.getProviderUri(getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR);
        getContentResolver().delete(carUri, RoadProProvider.FIELD_ID + "!=0", null);
        ArrayList<ContentValues> carValues = DummyCarSource.getCarData();
        for (ContentValues v : carValues)
            getContentResolver().insert(carUri, v);
        getContentResolver().notifyChange(carUri, null);
    }
}
