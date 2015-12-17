package com.rayan.venki.apps;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class Calculator extends Activity {

    EditText et1,et2;
    int num1,num2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    public void Calculation(View v) throws Throwable {



        try {

            et1 = (EditText) findViewById(R.id.editText2);
            et2 = (EditText) findViewById(R.id.editText3);
            tv = (TextView) findViewById(R.id.textView);
            num1=0;
            num2=0;
            num1 = Integer.parseInt(et1.getText().toString());
            num2 = Integer.parseInt(et2.getText().toString());
        } catch (Exception e) {
            Toast.makeText(Calculator.this, "enter valid number", Toast.LENGTH_SHORT).show();
        }




        switch (v.getId()) {
            case R.id.add:
                try {

                    tv.setText("" + (num1 + num2));
                    break;
                } catch (Exception e) {
                    Toast.makeText(Calculator.this, "enter valid number", Toast.LENGTH_SHORT).show();
                }
            case R.id.sub:
                try {

                    tv.setText("" + (num1 - num2));
                    break;
                } catch (Exception e) {
                    Toast.makeText(Calculator.this, "enter valid number", Toast.LENGTH_SHORT).show();
                }

            case R.id.mul:
                try {
                    tv.setText("" + (num1 * num2));
                    break;
                } catch (Exception e) {
                    Toast.makeText(Calculator.this, "enter valid number", Toast.LENGTH_SHORT).show();
                }

            case R.id.div:
                try {
                    tv.setText("" + (num1 / num2));
                    break;
                } catch (Exception e) {
                    tv.setText("infinite");
                    Toast.makeText(Calculator.this, "enter valid number", Toast.LENGTH_SHORT).show();
                }

            default:
                try {

                    tv.setText("" + (num1 % num2));
                    break;
                } catch (Exception e) {
                    tv.setText("infinite");
                    Toast.makeText(Calculator.this, "enter valid number", Toast.LENGTH_SHORT).show();
                }
        }


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
