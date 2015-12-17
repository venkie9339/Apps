package com.rayan.venki.apps;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class ActivityLifeCycleDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_life_cycle_demo);
        Log.i("venki", "OnCreate Called");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_life_cycle_demo, menu);
        return true;
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("venki", "OnStart Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("venki", "OnResume Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("venki", "OnPause Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("venki", "OnStop Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("venki", "OnDestroy Called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("venki", "OnRestart Called");
    }


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
    }
}
