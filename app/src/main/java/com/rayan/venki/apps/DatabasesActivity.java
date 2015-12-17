package com.rayan.venki.apps;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DatabasesActivity extends Activity {
	EditText etname,etEmail,etID;
	Button btadd,btdel,btupdt,btrtrv,btrtrvall,btdelall;
	//Long numID = null ;
	DBAdapter db;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_databases);

		db = new DBAdapter(this);
		etID = (EditText)findViewById(R.id.editText_id);
		etname = (EditText)findViewById(R.id.editText);
		etEmail = (EditText)findViewById(R.id.editText2);
		btadd = (Button)findViewById(R.id.btnAdd);
		btdel = (Button)findViewById(R.id.btnDel);
		btdelall = (Button)findViewById(R.id.btnDelAll);
		btupdt = (Button)findViewById(R.id.btnupdt);
		btrtrv = (Button)findViewById(R.id.btnrtrv);
		btrtrvall = (Button)findViewById(R.id.btnrtrvAll);




		//numID = Long.parseLong(etID.getText().toString().trim());



		btadd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

					// --- add a contact ---
					db.open();
					long id = db.insertContact(etname.getText().toString(), etEmail.getText().toString());


					Toast.makeText(DatabasesActivity.this,"data inserted!!!",Toast.LENGTH_SHORT).show();

					db.close();

			}
		});

		// delete contact
		btdel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				db.open();
				if (db.deleteContact(etID.getText().toString()))
					Toast.makeText(DatabasesActivity.this,
							"one record from the table deleted successfully.",
							Toast.LENGTH_LONG).show();
				else
					Toast.makeText(DatabasesActivity.this, "Delete failed.", Toast.LENGTH_LONG).show();
				db.close();

			}
		});

		//delete all
		btdelall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				db.open();
				if (db.deleteContacts())
					Toast.makeText(DatabasesActivity.this,
							"all records from the table deleted successfully.",
							Toast.LENGTH_LONG).show();
				else
					Toast.makeText(DatabasesActivity.this, "Delete failed.", Toast.LENGTH_LONG).show();
				db.close();

			}
		});
		//retrieve one contact
		btrtrv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				db.open();
				Cursor c = db.getContact(etID.getText().toString());
				if (c.moveToFirst())
					displayContact(c);
				else
					Toast.makeText(DatabasesActivity.this, "No contact found", Toast.LENGTH_LONG).show();
				db.close();

			}
		});
		//retrieve all contacts
		btrtrvall.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				db.open();
				Cursor c = db.getAllContacts();
				if (c.moveToFirst()) {
					do {
						displayContact(c);
					} while (c.moveToNext());
				} else
					Toast.makeText(DatabasesActivity.this, "No contact found", Toast.LENGTH_LONG).show();
				db.close();

			}
		});
		//update contacts
		btupdt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				db.open();
				if (db.updateContact(etID.getText().toString(), etname.getText().toString(), etEmail.getText().toString()))
					Toast.makeText(DatabasesActivity.this, "Update successful.", Toast.LENGTH_LONG)
							.show();
				else
					Toast.makeText(DatabasesActivity.this, "Update failed.", Toast.LENGTH_LONG).show();
				db.close();

			}
		});
	}





	private void displayContact(Cursor c) {
		Toast.makeText(
				getBaseContext(),
				"id: " + c.getString(0) + "\n" + "Name: " + c.getString(1)
						+ "\n" + "Email: " + c.getString(2) + "\n",
				Toast.LENGTH_LONG).show();
	}

}