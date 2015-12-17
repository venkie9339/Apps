package com.rayan.venki.apps;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BuiltinContentDemo extends Activity {
    private static final String TAG = "ContentUserDemo";
    private ArrayList<String> list;
    String email;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_builtin_content_demo);

        String[] projection = new String[] {
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
                ContactsContract.CommonDataKinds.Phone.NUMBER };

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;

        // getting the instance of the ContentResolver
        ContentResolver cr = getContentResolver();
        // getting the instance of the Cursor
        Cursor managedCursor = cr.query(uri, projection, null, null, null);

        // accessing data by using Cursor object
        managedCursor.moveToFirst();
        list = new ArrayList<String>();
        do {
            int nameFieldColumnIndex = managedCursor
                    .getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            String name = managedCursor.getString(nameFieldColumnIndex);

            int numberFieldColumnIndex = managedCursor
                    .getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER);
            String number = managedCursor.getString(numberFieldColumnIndex);

            list.add(name + ": " + number);
        } while (managedCursor.moveToNext());



        Log.d(TAG, "cursor.getCount()=" + managedCursor.getCount());

        // Get the list view
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);
        listView.setAdapter(aa);

    }
}