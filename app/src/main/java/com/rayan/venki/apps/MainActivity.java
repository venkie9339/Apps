package com.rayan.venki.apps;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showNotification(View view){
        Notification.Builder builder = new Notification.Builder(getBaseContext());
        builder.setContentTitle("Breaking News!!");
        builder.setContentText("Magic Coders are rocking");
        builder.setSmallIcon(R.drawable.ic_launcher);
        builder.setLargeIcon(BitmapFactory.decodeResource(this.getResources(), R.drawable.ic_launcher));
        builder.setAutoCancel(true);

        NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Notification notification =builder.getNotification();
        manager.notify(1,notification);


        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(3000);
        vibrator.vibrate(6000);
        vibrator.vibrate(3000);
        vibrator.vibrate(10000);
        vibrator.vibrate(6000);
        vibrator.vibrate(10000);
    }


    public void navigator(View view) {

        switch (view.getId()) {
            case R.id.btngu:

                Intent intentgu = new Intent(getBaseContext(), GreetUserActivity.class);
                startActivity(intentgu);
                break;
            case R.id.btnabtapp:

                Intent intentabtapp = new Intent(getBaseContext(), AboutAppActivity.class);
                startActivity(intentabtapp);
                break;

            case R.id.btnbltapp:

                Intent intentbltapp = new Intent(getBaseContext(), BuiltInAppActivity.class);
                startActivity(intentbltapp);
                break;

            case R.id.btnphtshp:

                Intent intentphtshp = new Intent(getBaseContext(), InstagramCloneActivity.class);
                startActivity(intentphtshp);
                break;
            case R.id.btnlyfcycl:

                Intent intentlyfcycl = new Intent(getBaseContext(), ActivityLifeCycleDemo.class);
                startActivity(intentlyfcycl);
                break;
            case R.id.btncmr:

                Intent intentcmr = new Intent(getBaseContext(), Camera.class);
                startActivity(intentcmr);
                break;
            case R.id.btncal:

                Intent intentcal = new Intent(getBaseContext(), Calculator.class);
                startActivity(intentcal);
                break;

            case R.id.btnaudio:

                Intent intentaudio = new Intent(getBaseContext(), AudioActivity.class);
                startActivity(intentaudio);
                break;
            case R.id.btnactnvg:

                Intent intentactnvg = new Intent(getBaseContext(), ActivityNavigator.class);
                startActivity(intentactnvg);
                break;
            case R.id.btnshrdprf:

                Intent intentshrdprf = new Intent(getBaseContext(), SharedPreferencesdemo.class);
                startActivity(intentshrdprf);
                break;
            case R.id.btnplytb:

                Intent intentplytb = new Intent(getBaseContext(), PlayYoutubeVideo.class);
                startActivity(intentplytb);
                break;
            case R.id.btnabr:

                Intent intentabr = new Intent(getBaseContext(), AlaramActivity.class);
                startActivity(intentabr);
                break;
            case R.id.btnpmd:

                Intent intentpmd = new Intent(getBaseContext(), MainAppActivity.class);
                startActivity(intentpmd);
                break;
            case R.id.btnlst:

                Intent intentlst = new Intent(getBaseContext(), ListViewDemo.class);
                startActivity(intentlst);
                break;

            case R.id.btnbcp:

                Intent intentbcp = new Intent(getBaseContext(), BuiltinContentDemo.class);
                startActivity(intentbcp);
                break;
            case R.id.btnsnsrlt:

                Intent intentsnsrlst = new Intent(getBaseContext(), SensorListDemo.class);
                startActivity(intentsnsrlst);
                break;
            case R.id.btnsnsr:

                Intent intentsnsr = new Intent(getBaseContext(), SensorDemo.class);
                startActivity(intentsnsr);
                break;
            case R.id.btnshake:

                Intent intentshake = new Intent(getBaseContext(), Shake.class);
                startActivity(intentshake);
                break;
            case R.id.btnsms:

                Intent intentsms = new Intent(getBaseContext(), SmsExample.class);
                startActivity(intentsms);
                break;
            case R.id.btntel:

                Intent intenttel = new Intent(getBaseContext(), TelephonyExample.class);
                startActivity(intenttel);
                break;
            case R.id.btnasync:

                Intent intentasync = new Intent(getBaseContext(), HttpActivity.class);
                startActivity(intentasync);
                break;
            case R.id.btnlclsrvc:

                Intent intentlclsrvc = new Intent(getBaseContext(), LocalServiceDemo.class);
                startActivity(intentlclsrvc);
                break;
            case R.id.btngmap:

                Intent intentgmap = new Intent(getBaseContext(), DisplayMapActivityDemo.class);
                startActivity(intentgmap);
                break;
            case R.id.btnsql:

                Intent intentsql = new Intent(getBaseContext(), DatabasesActivity.class);
                startActivity(intentsql);
                break;






            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
