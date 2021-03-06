package com.moana.roadpro_manage.base;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;

import okhttp3.OkHttpClient;

abstract public class BroadcastFragment extends ContentFragment {

    protected BroadcastReceiver receiver;
    protected IntentFilter filter;
    protected OkHttpClient mClient = new OkHttpClient();

    @Override
    public void onStart() {
        super.onStart();

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (null != intent) {
                    try {
                        if (intent.getAction().equals(ConstantDef.NETWORK_FAIL)) {
                            onNetworkFail(intent.getStringExtra(ConstantDef.ARG_STRING));
                        }
                        onReceiveBroadcast(intent.getAction(), intent);
                    } catch (Exception e) {

                    }
                }
            }
        };
    }

    @Override
    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();

        intentFilter.addAction(ConstantDef.NETWORK_FAIL);
        addIntentFilter(intentFilter);
        LocalBroadcastManager.getInstance(getContext()).registerReceiver(receiver, intentFilter);
    }

    @Override
    public void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(getContext()).unregisterReceiver(receiver);
    }

    public abstract void addIntentFilter(IntentFilter filter);
    public abstract void onReceiveBroadcast(String action, Intent intent);
    public abstract void onNetworkFail(String fail);
}