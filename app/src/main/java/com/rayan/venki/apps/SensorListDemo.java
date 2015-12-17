package com.rayan.venki.apps;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class SensorListDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_list_demo);
        TextView text = (TextView)findViewById(R.id.text);

        SensorManager mgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        List<Sensor> sensors = mgr.getSensorList(Sensor.TYPE_ALL);

        StringBuilder message = new StringBuilder(2048);
        message.append("The sensors on this device are:\n");

        for(Sensor sensor : sensors) {
            message.append(sensor.getName() + "\n");
            message.append("  Type: " + sensorTypes.get(sensor.getType()) + "\n");
            message.append("  Vendor: " + sensor.getVendor() + "\n");
            message.append("  Version: " + sensor.getVersion() + "\n");
            message.append("  Resolution: " + sensor.getResolution() + "\n");
            message.append("  Max Range: " + sensor.getMaximumRange() + "\n");
            message.append("  Power: " + sensor.getPower() + " mA\n");
        }
        text.setText(message);
    }

    private HashMap<Integer, String> sensorTypes = new HashMap<Integer, String>();

    { // Initialize the map of sensor type values and names
        sensorTypes.put(Sensor.TYPE_ACCELEROMETER, "TYPE_ACCELEROMETER"); // 1
        sensorTypes.put(Sensor.TYPE_GYROSCOPE, "TYPE_GYROSCOPE"); // 4
        sensorTypes.put(Sensor.TYPE_LIGHT, "TYPE_LIGHT"); // 5
        sensorTypes.put(Sensor.TYPE_MAGNETIC_FIELD, "TYPE_MAGNETIC_FIELD"); // 2
        sensorTypes.put(Sensor.TYPE_ORIENTATION, "TYPE_ORIENTATION"); // 3
        sensorTypes.put(Sensor.TYPE_PRESSURE, "TYPE_PRESSURE"); // 6
        sensorTypes.put(Sensor.TYPE_PROXIMITY, "TYPE_PROXIMITY"); // 8
        sensorTypes.put(Sensor.TYPE_TEMPERATURE, "TYPE_TEMPERATURE"); // 7
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sensor_list_demo, menu);
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
