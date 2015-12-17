package com.rayan.venki.apps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class SensorDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_demo);
    }

    public void navigator(View view) {

        switch (view.getId()) {
            case R.id.btngrvtsnsr:

                Intent intentgrvtsnsr = new Intent(getBaseContext(), GravitySensorDemo.class);
                startActivity(intentgrvtsnsr);
                break;
            case R.id.btnprxsnsr:

                Intent intentprxsnsr = new Intent(getBaseContext(), ProximitySensorDemo.class);
                startActivity(intentprxsnsr);
                break;
            case R.id.btnlghtsnsr:

                Intent intentlghtsnsr = new Intent(getBaseContext(), LightSensorDemo.class);
                startActivity(intentlghtsnsr);
                break;
            case R.id.btncmpssnsr:

                Intent intentcmpssnsr = new Intent(getBaseContext(), CompassSensorDemo.class);
                startActivity(intentcmpssnsr);
                break;
            case R.id.btnaclsnsr:

                Intent intentaclsnsr = new Intent(getBaseContext(), AcceloSensorDemo.class);
                startActivity(intentaclsnsr);
                break;



        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sensor_demo, menu);
        return true;
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
