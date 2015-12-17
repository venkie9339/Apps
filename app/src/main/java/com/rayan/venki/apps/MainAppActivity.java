package com.rayan.venki.apps;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainAppActivity extends Activity {
	PopupMenu popupMenu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// A Button that acts as the view element for the popup menu.

		final Button btn = (Button) findViewById(R.id.popupMenuBtn);

		// Step 1: Create a new instance of popup menu

		popupMenu = new PopupMenu(this, btn);

		// Step 2: Inflate the menu resource. Here the menu resource is defined
		// in the res/menu project folder

		popupMenu.inflate(R.menu.color_menu);
		

		// Step 3: Call show() method on the popup menu to display the menu when
		// the button is clicked.

		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				popupMenu.show();

			}
		});

		// Handle menu item clicks
		popupMenu
				.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						switch (item.getItemId()) {
						case R.id.menu_red:
							btn.setBackgroundResource(R.color.red);
							break;
						case R.id.menu_blue:
							btn.setBackgroundResource(R.color.blue);
							break;
						case R.id.menu_green:
							btn.setBackgroundResource(R.color.green);
							break;
						}
						return true;
					}
				});

	}
}