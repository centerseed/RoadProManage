package com.moana.roadpro_manage.plug;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.moana.roadpro_manage.base.ConstantDef;
import com.moana.roadpro_manage.park.ParkAdapter;
import com.moana.roadpro_manage.park.ParkInfoActivity;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlugAdapter extends AbstractRecyclerCursorAdapter {
    public PlugAdapter(Context context, Cursor c) {
        super(context, c);
    }

    boolean isDelete = false;
    PlugClickListener mListener;

    public interface PlugClickListener{
        void onPlugSelect(String parkId);
        void onPlugDelete(String parkId);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        PlugViewHolder vh = (PlugViewHolder) viewHolder;

        String url = cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_PLUG_STATION_PHOTO));
        if (url != null && url.length() > 0)
            Picasso.with(m_context).load(url).into(vh.mImageView);

        vh.mName.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_PLUG_STATION_NAME)));
        // vh.mID.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_ID)));
        vh.mAddress.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_PLUG_STATION_ADDRESS)));

        if (isDelete)
            vh.mDelete.setVisibility(View.VISIBLE);
        else
            vh.mDelete.setVisibility(View.GONE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_plug, parent, false);
        return new PlugAdapter.PlugViewHolder(v);
    }

    public void setParkClickListener(PlugClickListener listener) {
        mListener = listener;
    }

    public void toggleDelete() {
        isDelete = !isDelete;
        notifyDataSetChanged();
    }

    public class PlugViewHolder extends RecyclerView.ViewHolder {

        CircleImageView mImageView;
        TextView mID;
        TextView mName;
        TextView mAddress;
        ImageView mDelete;

        public PlugViewHolder(View itemView) {
            super(itemView);

            mImageView = (CircleImageView) itemView.findViewById(R.id.image);
            mID = (TextView) itemView.findViewById(R.id.id);
            mName = (TextView) itemView.findViewById(R.id.name);
            mAddress = (TextView) itemView.findViewById(R.id.address);
            mDelete = (ImageView) itemView.findViewById(R.id.delete);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor cursor = (Cursor) getItem(getAdapterPosition());

                    if (mListener != null) {
                        mListener.onPlugSelect(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_ID)));
                    }
                }
            });

            mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor cursor = (Cursor) getItem(getAdapterPosition());
                    if (mListener != null) {
                        mListener.onPlugDelete(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_ID)));
                    }
                }
            });
        }
    }
}
