package com.rayan.venki.apps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class TelephonyExample extends AppCompatActivity {
    public static final String NUMBER = "9036151890";

    private Button dialintent;
    private Button callintent;

    @Override
    public void onCreate(final Bundle icicle) {
        super.onCreate(icicle);
        this.setContentView(R.layout.activity_telephony_example);


        this.dialintent = (Button) findViewById(R.id.dialintent_button);
        this.dialintent.setOnClickListener(new View.OnClickListener() {

            public void onClick(final View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"
                        + TelephonyExample.NUMBER));
                startActivity(intent);
            }
        });

        this.callintent = (Button) findViewById(R.id.callintent_button);
        this.callintent.setOnClickListener(new View.OnClickListener() {

            public void onClick(final View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                        + TelephonyExample.NUMBER));
                startActivity(intent);

            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onPause() {
        super.onPause();
    }


}
