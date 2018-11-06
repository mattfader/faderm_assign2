package com.example.fader.sda_2018_assign2matthewfader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {
    //public Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init();
    }

    /*
    This is the button method to run the default system camera app.
    see section Start a camera app in still image mode - https://developer.android.com/guide/components/intents-common#CameraStill
    */
    public void button1(View view) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            byte REQUEST_IMAGE_CAPTURE = 0;
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
            //https://developer.android.com/guide/components/intents-common#CameraStill
        }
    }
    /*
    This is code responsible for calling the gallery app and then returning back to the app
    see section on retrieving a specific file type - https://developer.android.com/guide/components/intents-common#CameraStill
    */
    static final int REQUEST_IMAGE_GET = 1;

    public void button2(View view) {

        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_GET);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_GET && resultCode == RESULT_OK) {
            Bitmap thumbnail = data.getParcelableExtra("data");
            Uri fullPhotoUri = data.getData();
            // Do work with photo saved at fullPhotoUri
        }
    }




    /*
    This is the button to loads the activity 2 page with the text fields to fill in.
    This info is sourced from the course text/videos
    */
    public void button3(View v) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(intent);}


}
