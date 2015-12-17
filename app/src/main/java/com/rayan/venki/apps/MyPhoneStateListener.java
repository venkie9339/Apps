package com.rayan.venki.apps;

/**
 * Created by venkie on 13-12-2015.
 */
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class MyPhoneStateListener extends PhoneStateListener {

    public void onCallStateChange(int state, String incomingNumber){

        System.out.println("Icoming Number inside onCallStateChange : "  + incomingNumber);
        switch(state){
            case TelephonyManager.CALL_STATE_RINGING:
                System.out.println("PHONE RINGING.........TAKE IT.........");
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                System.out.println("CALL_STATE_OFFHOOK...........");
                break;
        }
    }
}

