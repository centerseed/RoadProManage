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
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class ParkAdapter extends AbstractRecyclerCursorAdapter {
    public ParkAdapter(Context context, Cursor c) {
        super(context, c);
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
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_park, parent, false);
        return new ParkAdapter.CarViewHolder(v);
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {

        CircleImageView mImageView;
        TextView mID;
        TextView mName;
        TextView mAddress;

        public CarViewHolder(View itemView) {
            super(itemView);

            mImageView = (CircleImageView) itemView.findViewById(R.id.image);
            mID = (TextView) itemView.findViewById(R.id.id);
            mName = (TextView) itemView.findViewById(R.id.name);
            mAddress = (TextView) itemView.findViewById(R.id.address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor cursor = (Cursor) getItem(getAdapterPosition());

                    Intent intent = new Intent(m_context, ParkInfoActivity.class);
                    intent.putExtra(ConstantDef.ARG_STRING, cursor.getString(cursor.getColumnIndex(RoadProProvider.FIELD_ID)));
                    m_context.startActivity(intent);
                }
            });
        }
    }
}
