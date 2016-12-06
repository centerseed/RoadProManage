package com.moana.roadpro_manage.car;

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

public class CarAdapter extends AbstractRecyclerCursorAdapter {
    public CarAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        CarViewHolder vh = (CarViewHolder) viewHolder;

        vh.mCarNo.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_NO)));
        vh.mYear.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_FACTORY_YEAR)));
        vh.mMileage.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_MILEAGE)));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_car, parent, false);
        return new CarAdapter.CarViewHolder(v);
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {
        TextView mCarNo;
        TextView mYear;
        TextView mMileage;

        public CarViewHolder(View itemView) {
            super(itemView);

            mCarNo = (TextView) itemView.findViewById(R.id.car_id);
            mYear = (TextView) itemView.findViewById(R.id.year);
            mMileage = (TextView) itemView.findViewById(R.id.mileage);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor cursor = (Cursor) getItem(getAdapterPosition());
                    String carNo = cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_NO));

                    Intent intent = new Intent(m_context, CarInfoActivity.class);
                    intent.putExtra(ConstantDef.ARG_STRING, carNo);
                    m_context.startActivity(intent);
                }
            });
        }
    }
}
