package com.moana.roadpro_manage.park;

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
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ParkAdapter extends AbstractRecyclerCursorAdapter {
    public ParkAdapter(Context context, Cursor c) {
        super(context, c);
    }

    boolean isDelete = false;
    ParkClickListener mListener;

    public interface ParkClickListener{
        void onParkSelect(String parkId);
        void onParkDelete(String parkId);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        CarViewHolder vh = (CarViewHolder) viewHolder;

        String url = cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_PHOTO));
        if (url != null && url.length() > 0)
            Picasso.with(m_context).load(url).into(vh.mImageView);

        vh.mName.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_NAME)));
        // vh.mID.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_ID)));
        vh.mAddress.setText(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_CAR_STATION_ADDRESS)));

        if (isDelete)
            vh.mDelete.setVisibility(View.VISIBLE);
        else
            vh.mDelete.setVisibility(View.GONE);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_park, parent, false);
        return new ParkAdapter.CarViewHolder(v);
    }

    public void setParkClickListener(ParkClickListener listener) {
        mListener = listener;
    }

    public void toggleDelete() {
        isDelete = !isDelete;
        notifyDataSetChanged();
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {

        CircleImageView mImageView;
        ImageView mDelete;
        TextView mID;
        TextView mName;
        TextView mAddress;

        public CarViewHolder(View itemView) {
            super(itemView);

            mImageView = (CircleImageView) itemView.findViewById(R.id.image);
            mDelete = (ImageView) itemView.findViewById(R.id.delete);
            mID = (TextView) itemView.findViewById(R.id.id);
            mName = (TextView) itemView.findViewById(R.id.name);
            mAddress = (TextView) itemView.findViewById(R.id.address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor cursor = (Cursor) getItem(getAdapterPosition());

                    if (mListener != null) {
                        mListener.onParkSelect(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_ID)));
                    }
                }
            });

            mDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor cursor = (Cursor) getItem(getAdapterPosition());
                    if (mListener != null) {
                        mListener.onParkDelete(cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_ID)));
                    }
                }
            });
        }
    }
}
