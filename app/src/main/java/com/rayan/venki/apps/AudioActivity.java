package com.rayan.venki.apps;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

public class AudioActivity extends Activity {


    private MediaPlayer mediaPlayer;
    private static boolean isPlaying;
    private ImageButton imBtnPlayPause;


    public void audioPlayer(View view){
        switch (view.getId()){
            case R.id.imBtnPlayPause:
                if(isPlaying){
                    mediaPlayer.stop();
                    isPlaying = false;
                    initilize();
                    imBtnPlayPause.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.play));
                } else {
                    mediaPlayer.start();
                    isPlaying = true;
                    imBtnPlayPause.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.pause));
                }
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        imBtnPlayPause = (ImageButton) findViewById(R.id.imBtnPlayPause);
        initilize();
    }

    private void initilize() {

        mediaPlayer = MediaPlayer.create(getBaseContext(), R.raw.one);




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_audio, menu);
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
