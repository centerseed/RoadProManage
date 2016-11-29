package com.moana.roadpro_manage.park;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;

public class RentCountAdapter extends AbstractRecyclerCursorAdapter {
    public RentCountAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {
        RentViewHolder vh = (RentViewHolder) viewHolder;
        vh.mRank.setText((cursor.getPosition() + 1) + "");
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_rent_count, parent, false);
        return new RentViewHolder(v);
    }

    public class RentViewHolder extends RecyclerView.ViewHolder {
        TextView mRank;

        public RentViewHolder(View itemView) {
            super(itemView);

            mRank = (TextView) itemView.findViewById(R.id.rank);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }
    }
}
