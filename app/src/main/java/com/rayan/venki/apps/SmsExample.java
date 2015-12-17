package com.rayan.venki.apps;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SmsExample extends Activity {

    private EditText smsInputText;
    private EditText smsInputDest;
    private Button smsSend;
    private SmsManager smsManager;
    public static final String LOGTAG = "TelephonyExplorer";

    @Override
    public void onCreate(final Bundle icicle) {
        Log.d(LOGTAG, "SmsExample onCreate");

        super.onCreate(icicle);
        this.setContentView(R.layout.activity_sms_example);

        this.smsInputDest = (EditText) findViewById(R.id.smsinputdest);
        this.smsInputText = (EditText) findViewById(R.id.smsinputtext);
        this.smsSend = (Button) findViewById(R.id.smssend_button);

        this.smsManager = SmsManager.getDefault();

        // pending intent request code NOT USED
        final PendingIntent sentIntent = PendingIntent.getActivity(this, 0,
                new Intent(this, SmsExample.class), 0);

        this.smsSend.setOnClickListener(new OnClickListener() {

            public void onClick(final View v) {
                Log.d(LOGTAG, "SmsExample sending SMS message via manager");

                String dest = smsInputDest.getText().toString();
                if (PhoneNumberUtils.isWellFormedSmsAddress(dest)) {

                    // dest, serviceCenter (null for default), message,
                    // sentIntent, deliveryIntent
                    //
                    // Set the second parameter to null. The scAddress relates
                    // to the address of the server on the cellular network that
                    // will handle
                    // the message, it is not the address of the sender.
                    smsManager.sendTextMessage(smsInputDest.getText()
                            .toString(), null, smsInputText.getText()
                            .toString(), sentIntent, null);

                    Toast.makeText(SmsExample.this, "SMS message sent",
                            Toast.LENGTH_LONG).show();

                } else {
                    Toast.makeText(SmsExample.this,
                            "SMS destination invalid - try again",
                            Toast.LENGTH_LONG).show();
                }
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
