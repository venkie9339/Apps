package com.rayan.venki.apps;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class Utils {
	
	
	public static void toastItBaby(Context context, String msg){
		Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}

}
