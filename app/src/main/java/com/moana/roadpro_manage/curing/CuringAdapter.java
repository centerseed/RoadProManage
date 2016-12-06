package com.moana.roadpro_manage.curing;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;

public class CuringAdapter extends AbstractRecyclerCursorAdapter {

    public CuringAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        CuringViewHolder vh = (CuringViewHolder) viewHolder;
        String carID = cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_NO));

        vh.mTime.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_MAINTAIN_DATE)));
        vh.mCarId.setText(carID);
        vh.mReason.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_MAINTAIN_REASON)));
        vh.mRepairItem.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL)));
        vh.mMileage.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_MAINTAIN_MILEAGE)));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_curing, parent, false);
        return new CuringViewHolder(v);
    }

    public class CuringViewHolder extends RecyclerView.ViewHolder {
        TextView mTime;
        TextView mCarId;
        TextView mMileage;
        TextView mReason;
        TextView mRepairItem;

        public CuringViewHolder(View itemView) {
            super(itemView);

            mTime = (TextView) itemView.findViewById(R.id.time);
            mCarId = (TextView) itemView.findViewById(R.id.car_id);
            mMileage = (TextView) itemView.findViewById(R.id.mileage);
            mReason = (TextView) itemView.findViewById(R.id.reason);
            mRepairItem = (TextView) itemView.findViewById(R.id.repair_item);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }
    }
}
