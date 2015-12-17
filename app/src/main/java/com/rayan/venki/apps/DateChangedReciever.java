package com.rayan.venki.apps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by venkie on 12-12-2015.
 */
public class DateChangedReciever extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_DATE_CHANGED)) {
            Log.e("", "ACTION_DATE_CHANGED received");
        }
    }
}
