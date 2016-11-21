package com.moana.roadpro_manage.park;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.ev_car.CarInfoActivity;

public class ParkAdapter extends AbstractRecyclerCursorAdapter {
    public ParkAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_park, parent, false);
        return new ParkAdapter.CarViewHolder(v);
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {

        public CarViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor cursor = (Cursor) getItem(getAdapterPosition());

                    Intent intent = new Intent(m_context, ParkInfoActivity.class);
                    m_context.startActivity(intent);
                }
            });
        }
    }
}
