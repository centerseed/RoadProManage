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

public class RentCountAdapter extends AbstractRecyclerCursorAdapter {

    Uri mParkUri;
    ContentResolver mResolver;

    public RentCountAdapter(Context context, Cursor c) {
        super(context, c);
        mParkUri = RoadProProvider.getProviderUri(context.getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_CAR_STATION);
        mResolver = m_context.getContentResolver();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        RentViewHolder vh = (RentViewHolder) viewHolder;
        String carStationID = cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_ID));
        Cursor data = mResolver.query(mParkUri, null, RoadProProvider.FIELD_ID + "=?", new String[]{carStationID}, null);
        vh.mRank.setText((cursor.getPosition() + 1) + "");

        if (data.moveToFirst()) {
            vh.mName.setText(data.getString(data.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_NAME)));
        }
        vh.mCount.setText(cursor.getInt(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_REPORT_RENT_COUNT)) + "");
        data.close();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_rent_count, parent, false);
        return new RentViewHolder(v);
    }

    public class RentViewHolder extends RecyclerView.ViewHolder {
        TextView mName;
        TextView mRank;
        TextView mCount;

        public RentViewHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.name);
            mRank = (TextView) itemView.findViewById(R.id.rank);
            mCount = (TextView) itemView.findViewById(R.id.count);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }
    }
}
