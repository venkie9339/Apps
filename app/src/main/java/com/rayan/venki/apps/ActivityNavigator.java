package com.rayan.venki.apps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityNavigator extends Activity {


    private static final String NEWS_TYPE = "" ;

    public void navigate(View view){
        switch (view.getId()){

            case R.id.btnApple:

                Intent intentAppleNews = new Intent(this, NewsActivity.class);
                intentAppleNews.putExtra(NEWS_TYPE, "Apple");
                startActivity(intentAppleNews);

                break;

            case R.id.btnGoogleNews:
                Intent intentGoogleNews = new Intent(this, NewsActivity.class);
                intentGoogleNews.putExtra(NEWS_TYPE, "Google");
                startActivity(intentGoogleNews);
                break;



        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigator);
    }
}
