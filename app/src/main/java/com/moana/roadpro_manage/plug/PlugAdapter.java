package com.moana.roadpro_manage.plug;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.RoadProProvider;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class PlugAdapter extends AbstractRecyclerCursorAdapter {
    public PlugAdapter(Context context, Cursor c) {
        super(context, c);
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
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_plug, parent, false);
        return new PlugAdapter.PlugViewHolder(v);
    }

    public class PlugViewHolder extends RecyclerView.ViewHolder {

        CircleImageView mImageView;
        TextView mID;
        TextView mName;
        TextView mAddress;

        public PlugViewHolder(View itemView) {
            super(itemView);

            mImageView = (CircleImageView) itemView.findViewById(R.id.image);
            mID = (TextView) itemView.findViewById(R.id.id);
            mName = (TextView) itemView.findViewById(R.id.name);
            mAddress = (TextView) itemView.findViewById(R.id.address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Cursor cursor = (Cursor) getItem(getAdapterPosition());

                    // Intent intent = new Intent(m_context, ParkInfoActivity.class);
                    // m_context.startActivity(intent);
                }
            });
        }
    }
}
