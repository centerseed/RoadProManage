package com.moana.roadpro_manage.curing;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moana.roadpro_manage.R;
import com.moana.roadpro_manage.base.AbstractRecyclerCursorAdapter;

public class CuringAdapter extends AbstractRecyclerCursorAdapter {
    public CuringAdapter(Context context, Cursor c) {
        super(context, c);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, Cursor cursor) {

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = m_inflater.inflate(R.layout.listitem_curing, parent, false);
        return new CarViewHolder(v);
    }

    public class CarViewHolder extends RecyclerView.ViewHolder {
        TextView charge;

        public CarViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                }
            });
        }
    }
}
