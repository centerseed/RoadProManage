package com.moana.roadpro_manage;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout mListEvCar;
    LinearLayout mListCar;
    LinearLayout mListPlug;

    TextView mItemIntroduce;
    LinearLayout mItemCarActivity;
    LinearLayout mItemCarList;
    LinearLayout mItemCarMaintain;
    LinearLayout mItemCarManageReport;
    LinearLayout mItemParkSearch;
    LinearLayout mItemParkManage;
    LinearLayout mItemparkReport;
    LinearLayout mItemPlugActivity;
    LinearLayout mItemPlugManage;
    LinearLayout mItemPlugReport;
    Toolbar mToolbar;
    ImageView mToolbarIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");

        mToolbarIcon = (ImageView) mToolbar.findViewById(R.id.toolbar_icon);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initDrawerHeader(navigationView);

        Fragment f = new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, f).commit();
        mToolbarIcon.setVisibility(View.GONE);

        mToolbarIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.container, f).commit();
                mToolbarIcon.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        return true;
    }

    private void collapseAllList() {
        mListEvCar.setVisibility(View.GONE);
        mListCar.setVisibility(View.GONE);
        mListPlug.setVisibility(View.GONE);
    }

    class DrawerClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            mToolbarIcon.setVisibility(View.VISIBLE);
            Log.e("Drawer Click", "view id -> " + view.getId());

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
                collapseAllList();
                switch (i) {
                    case R.id.ev_car_manage:
                        mListEvCar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.car_manage_system:
                        mListCar.setVisibility(View.VISIBLE);
                        break;
                    case R.id.plug_manage_system:
                        mListPlug.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });

        DrawerClickListener drawerClickListener = new DrawerClickListener();
        group.setOnClickListener(drawerClickListener);

        mListEvCar = (LinearLayout) headerView.findViewById(R.id.list_ev_car);
        mListCar = (LinearLayout) headerView.findViewById(R.id.list_car);
        mListPlug = (LinearLayout) headerView.findViewById(R.id.list_plug);

        mItemIntroduce = (TextView) headerView.findViewById(R.id.introduce);
        mItemCarActivity = (LinearLayout) headerView.findViewById(R.id.car_activity);
        mItemCarList = (LinearLayout) headerView.findViewById(R.id.car_list);
        mItemCarMaintain = (LinearLayout) headerView.findViewById(R.id.car_maintain);
        mItemCarManageReport = (LinearLayout) headerView.findViewById(R.id.car_manage_report);
        mItemParkSearch = (LinearLayout) headerView.findViewById(R.id.park_search);
        mItemParkManage = (LinearLayout) headerView.findViewById(R.id.park_manage);
        mItemparkReport = (LinearLayout) headerView.findViewById(R.id.park_report);
        mItemPlugActivity = (LinearLayout) headerView.findViewById(R.id.plug_search);
        mItemPlugManage = (LinearLayout) headerView.findViewById(R.id.plug_manage);
        mItemPlugReport = (LinearLayout) headerView.findViewById(R.id.plug_report);

        mItemIntroduce.setOnClickListener(drawerClickListener);
        mItemCarActivity.setOnClickListener(drawerClickListener);
        mItemCarList.setOnClickListener(drawerClickListener);
        mItemCarMaintain.setOnClickListener(drawerClickListener);
        mItemCarManageReport.setOnClickListener(drawerClickListener);
        mItemParkSearch.setOnClickListener(drawerClickListener);
        mItemParkManage.setOnClickListener(drawerClickListener);
        mItemparkReport.setOnClickListener(drawerClickListener);
        mItemPlugActivity.setOnClickListener(drawerClickListener);
        mItemPlugManage.setOnClickListener(drawerClickListener);
        mItemPlugReport.setOnClickListener(drawerClickListener);
    }
}
