package com.moana.roadpro_manage.car;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;

public class CarMaintainAdapter extends AbstractRecyclerCursorAdapter {
    public CarMaintainAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        MaintainViewHolder vh = (MaintainViewHolder) viewHolder;
        vh.mTime.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_MAINTAIN_DATE)));
        vh.mReason.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_MAINTAIN_REASON)));
        vh.mRepairItem.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_MAINTAIN_ITEM_DETAIL)));
        vh.mMileage.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_MAINTAIN_MILEAGE)));
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_maintain, parent, false);
        return new CarMaintainAdapter.MaintainViewHolder(v);
    }

    public class MaintainViewHolder extends RecyclerView.ViewHolder {
        TextView mTime;
        TextView mMileage;
        TextView mReason;
        TextView mRepairItem;

        public MaintainViewHolder(View itemView) {
            super(itemView);

            mTime = (TextView) itemView.findViewById(R.id.time);
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
