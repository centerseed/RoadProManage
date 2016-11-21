package com.moana.roadpro_manage.park;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.moana.roadpro_manage.R;
import com.squareup.picasso.Picasso;

public class ParkInfoActivity extends AppCompatActivity {

    ImageView mPark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_park_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("停車場資訊");

        mPark = (ImageView) findViewById(R.id.park_img);
        Picasso.with(this).load("http://www.nrel.gov/continuum/energy_integration/assets/images/photo_news5_nrel21661_large.jpg").into(mPark);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_edit, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
