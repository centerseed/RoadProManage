package com.moana.roadpro_manage.plug;

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
import com.moana.roadpro_manage.utils.TimeUtils;


public class PlugUsageAdapter extends AbstractRecyclerCursorAdapter {

    Uri mPlugUri;
    PlugUsageListener mListener;

    public interface PlugUsageListener {
        void onPlugSelected(String id);
    }

    public PlugUsageAdapter(Context context, Cursor c) {
        super(context, c);
        mPlugUri = RoadProProvider.getProviderUri(context.getString(R.string.auth_provider_roadpro), RoadProProvider.TABLE_PLUG_STATION);
    }

    public void setOnClickListener(PlugUsageListener listener) {
        mListener = listener;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        int plugID = cursor.getInt(cursor.getColumnIndex(RoadProProvider.FIELD_PLUG_STATION_ID));
        Cursor data = m_context.getContentResolver().query(mPlugUri, null, RoadProProvider.FIELD_ID + "=?", new String[]{plugID + ""}, null);

        PlugViewHolder vh = (PlugViewHolder) viewHolder;
        if (data.moveToFirst()) {
            vh.mName.setText(data.getString(data.getColumnIndex(RoadProProvider.FIELD_PLUG_STATION_NAME)));
            data.close();
        }

        vh.mUsage.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_PLUG_USAGE)));
        vh.mTime.setText(TimeUtils.getMMDD(m_context, cursor.getLong(cursor.getColumnIndex(RoadProProvider.FIELD_TIME)) * 1000));
        vh.mRank.setText((cursor.getPosition() + 1) + "");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_plug_usage, parent, false);
        return new PlugUsageAdapter.PlugViewHolder(v);
    }

    public class PlugViewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        TextView mUsage;
        TextView mTime;
        TextView mRank;

        public PlugViewHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.name);
            mUsage = (TextView) itemView.findViewById(R.id.usage);
            mTime = (TextView) itemView.findViewById(R.id.time);
            mRank = (TextView) itemView.findViewById(R.id.rank);

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
