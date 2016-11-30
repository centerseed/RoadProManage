package com.moana.roadpro_manage.park;

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


public class ParkRevenueAdapter extends AbstractRecyclerCursorAdapter {
    Uri mParkUri;
    PlugUsageListener mListener;
    ContentResolver mResolver;

    public interface PlugUsageListener {
        void onPlugSelected(String id);
    }

    public ParkRevenueAdapter(Context context, Cursor c) {
        super(context, c);
        mParkUri = RoadProProvider.getProviderUri(context.getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR_STATION);
        mResolver = context.getContentResolver();
    }

    public void setOnClickListener(PlugUsageListener listener) {
        mListener = listener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        ParkViewHolder vh = (ParkViewHolder) viewHolder;
        String carStationID = cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_ID));
        Cursor data = mResolver.query(mParkUri, null, RoadProProvider.FIELD_ID + "=?", new String[]{carStationID}, null);

        if (data.moveToFirst()) {
            vh.mMonth.setText(data.getString(data.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_NAME)));
        }
        data.close();

        vh.mRent.setText((cursor.getInt(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_REVENUE_RENT_INCOME)) + ""));
        vh.mOther.setText((cursor.getInt(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_REVENUE_OTHER_INCOME))) + "");
        vh.mNet.setText((cursor.getInt(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_REVENUE_NET))) + "");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_revenue, parent, false);
        return new ParkRevenueAdapter.ParkViewHolder(v);
    }

    public class ParkViewHolder extends RecyclerView.ViewHolder {

        TextView mMonth;
        TextView mRent;
        TextView mOther;
        TextView mNet;

        public ParkViewHolder(View itemView) {
            super(itemView);

            mMonth = (TextView) itemView.findViewById(R.id.month);
            mRent = (TextView) itemView.findViewById(R.id.rent_income);
            mOther = (TextView) itemView.findViewById(R.id.other_income);
            mNet = (TextView) itemView.findViewById(R.id.net);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        Cursor cursor = (Cursor) getItem(getAdapterPosition());
                        mListener.onPlugSelected(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_ID)));
                    }
                }
            });
        }
    }
}
