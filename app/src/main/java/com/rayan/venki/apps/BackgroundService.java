/*
 * 
 */
package com.rayan.venki.apps;

// BackgroundService.java

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

// TODO: Auto-generated Javadoc
/**
 * The Class BackgroundService.
 */
public class BackgroundService extends Service {
    private static final int NOTIFICATION = 1;
    public static final String CLOSE_ACTION = "close";
    private NotificationManager mNotificationManager = null;
    private final NotificationCompat.Builder mNotificationBuilder = new NotificationCompat.Builder(this);


    /**
     * The Constant TAG.
     */
    private static final String TAG = "BackgroundService";

    /**
     * The notification mgr.
     */
    private NotificationManager notificationMgr;

    /**
     * The my threads.
     */
    private ThreadGroup myThreads = new ThreadGroup("ServiceWorker");

    /* (non-Javadoc)
     * @see android.app.Service#onCreate()
     */
    @Override
    public void onCreate() {
        super.onCreate();


        Log.v(TAG, "in onCreate()");
        notificationMgr = (NotificationManager) getSystemService(
                NOTIFICATION_SERVICE);
        setupNotifications();
        showNotification();

    }

    /* (non-Javadoc)
     * @see android.app.Service#onStartCommand(android.content.Intent, int, int)
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Bundle bundle = intent.getExtras();
        int counter = bundle.getInt("counter");

        Log.v(TAG, "in onStartCommand(), counter = " + counter +
                ", startId = " + startId);

        ServiceWorker worker = new ServiceWorker(counter);
        Thread thread = new Thread(myThreads, worker, "BackgroundService");
        thread.start();

        return START_NOT_STICKY;
    }

    /**
     * The Class ServiceWorker, to create a separate thread as an execution in the Service
     */
    class ServiceWorker implements Runnable {

        /**
         * The counter.
         */
        private int counter = -1;

        /**
         * Instantiates a new service worker.
         *
         * @param counter the counter
         */
        public ServiceWorker(int counter) {
            this.counter = counter;
        }

        /* (non-Javadoc)
         * @see java.lang.Runnable#run()
         */
        public void run() {
            final String TAG2 = "ServiceWorker:" + Thread.currentThread().getId();
            // do background processing here...
            try {
                Log.v(TAG2, "sleeping for 10 seconds. counter = " + counter);
                Thread.sleep(10000);
                Log.v(TAG2, "... waking up");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                Log.v(TAG2, "... sleep interrupted");
            }
        }
    }

    /* (non-Javadoc)
     * @see android.app.Service#onDestroy()
     */
    @Override
    public void onDestroy() {
        Log.v(TAG, "in onDestroy(). Interrupting threads and cancelling notifications");
        String text = "Email Service being stopped and cancelling notifications";
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();

        // Interrupts all the threads
        myThreads.interrupt();

        // Cancel all previously displayed notifications
        notificationMgr.cancelAll();
        super.onDestroy();
    }

    /* (non-Javadoc)
     * @see android.app.Service#onBind(android.content.Intent)
     */
    @Override
    public IBinder onBind(Intent intent) {
        // Since we are not binding to a service
        Log.v(TAG, "in onBind()");
        return null;
    }

    private void setupNotifications() { //called in onCreate()
        if (mNotificationManager == null) {
            mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        }
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, LocalServiceDemo.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP),
                0);
        PendingIntent pendingCloseIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, LocalServiceDemo.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP)
                        .setAction(CLOSE_ACTION),
                0);
        mNotificationBuilder
                .setSmallIcon(R.drawable.emo_im_winking)
                .setCategory(NotificationCompat.CATEGORY_SERVICE)
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setContentTitle(getText(R.string.app_name))
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .addAction(android.R.drawable.ic_menu_close_clear_cancel,
                        getString(R.string.stop), pendingCloseIntent)
                .setOngoing(true);
    }

    private void showNotification() {
        mNotificationBuilder
                .setTicker("this is ticker")
                .setContentText("Notification!!!");
        if (mNotificationManager != null) {
            mNotificationManager.notify(NOTIFICATION, mNotificationBuilder.build());
        }


    }
}
