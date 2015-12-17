package com.rayan.venki.apps;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;

public class SharedPreferencesdemo extends AppCompatActivity {


    RadioButton rbWhite, rbBlue, rbGreen;
    String myPref = "MyBgPref";
    final String COLOR_KEY = "COLOR_KEY";
    LinearLayout llParent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferencesdemo);
        rbWhite = (RadioButton) findViewById(R.id.rbWhite);
        rbGreen = (RadioButton) findViewById(R.id.rbGreen);
        rbBlue = (RadioButton) findViewById(R.id.rbBlue);
        llParent = (LinearLayout) findViewById(R.id.llParent);

        SharedPreferences sharedPreferences = getSharedPreferences(myPref, MODE_PRIVATE);
        int rbId = sharedPreferences.getInt(COLOR_KEY, -1);
        if(rbId == R.id.rbBlue){
            llParent.setBackgroundColor(Color.parseColor("#0000ff"));
        } else if(rbId ==R.id.rbGreen){
            llParent.setBackgroundColor(Color.parseColor("#00ff00"));
        }
    }

    public void changeBackground(View view) {

        SharedPreferences sharedPreferences = getSharedPreferences(myPref, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();


        switch (view.getId()) {
            case R.id.rbBlue :
                llParent.setBackgroundColor(Color.parseColor("#0000ff"));
                editor.putInt(COLOR_KEY, R.id.rbBlue);
                editor.commit();
                break;
            case R.id.rbGreen:
                llParent.setBackgroundColor(Color.parseColor("#00ff00"));
                editor.putInt(COLOR_KEY, R.id.rbGreen);
                editor.commit();
                break;
            case R.id.rbWhite:
                llParent.setBackgroundColor(Color.parseColor("#ffffff"));
                editor.putInt(COLOR_KEY, R.id.rbWhite);
                editor.commit();
                break;
        }
    }
}
