package com.rayan.venki.apps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    private static final String NEWS_TYPE = "";
    private TextView tvNews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        tvNews = (TextView) findViewById(R.id.tvNews);

        Intent intent = getIntent();

        String newsType = intent.getStringExtra(NEWS_TYPE);

        if(newsType.equals("Apple")){
            tvNews.setText("Todays Apple news");
        }

        if(newsType.equals("Google")){
            tvNews.setText("Todays Google news");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_news, menu);
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
