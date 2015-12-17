package com.rayan.venki.apps;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class InstagramCloneActivity extends AppCompatActivity {
    Intent incomingIntent;
    private ImageView ivResult;

    public void doImageEffects(View view){
        ivResult.buildDrawingCache();
        Bitmap original = ivResult.getDrawingCache();


        switch (view.getId()){
            case R.id.btnGrayScale:
                Bitmap grayScaleBitMap = toGrayScale(original);
                ivResult.setImageBitmap(grayScaleBitMap);
                break;
            default:
                break;
        }
    }

    public Bitmap toGrayScale(Bitmap bmpOriginal){
        int width, height;
        height = bmpOriginal.getHeight();
        width = bmpOriginal.getWidth();

        Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bmpGrayscale);
        Paint paint = new Paint();
        ColorMatrix cm = new ColorMatrix();
        cm.setSaturation(0);
        ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
        paint.setColorFilter(f);
        c.drawBitmap(bmpOriginal, 0, 0, paint);
        return bmpGrayscale;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instagram_clone);

        ivResult = (ImageView) findViewById(R.id.ivResult);
        Log.i("venki", "about to get Intent");
        incomingIntent = getIntent();
        Log.i("venki", "Got Intent");
        try {

            Uri imageUri = (Uri) getIntent().getExtras().get(Intent.EXTRA_STREAM);
            Log.i("venki", imageUri.toString());
            ivResult.setImageURI(imageUri);

        }
        catch (Exception e){

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_instagram_clone, menu);
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
