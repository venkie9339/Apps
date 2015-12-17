package com.rayan.venki.apps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


/**
 * The Class MainActivity.
 */
public class LocalServiceDemo extends Activity {

    /** The Constant TAG. */
    private static final String TAG = "MainActivity";

    /** The counter. */
    private int counter = 1;

    /* (non-Javadoc)
     * @see android.app.Activity#onCreate(android.os.Bundle)
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_service_demo);
    }

    /**
     * Handles all the button clicks in the user interface.
     *
     * @param view the view
     */
    public void doClick(View view) {
        switch (view.getId()) {
            case R.id.startBtn:
                startService();
                break;
            case R.id.stopBtn:
                stopService();
                break;
        }
    }

    /**
     * Stops a service.
     */
    private void stopService() {
        Log.v(TAG, "Stopping service...");
        if (stopService(new Intent(LocalServiceDemo.this, BackgroundService.class)))
            Log.v(TAG, "stopService was successful");
        else
            Log.v(TAG, "stopService was unsuccessful");
    }


    /**
     * Starts a service.
     */
    private void startService() {
        Log.v(TAG, "Starting service... counter = " + counter);
        Intent intent = new Intent(LocalServiceDemo.this,
                BackgroundService.class);
        intent.putExtra("counter", counter++);
        startService(intent);
    }

    /* (non-Javadoc)
     * stop the service before the activity is getting destroyed.
     * @see android.app.Activity#onDestroy()
     */
    @Override
    public void onDestroy() {
        stopService();
        super.onDestroy();
    }
}