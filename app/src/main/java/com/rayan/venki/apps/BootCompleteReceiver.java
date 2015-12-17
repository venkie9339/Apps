package com.rayan.venki.apps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootCompleteReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Utils.toastItBaby(context, " boot complete . . . Now I will start my app");
	}

}
