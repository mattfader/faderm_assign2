package com.example.fader.sda_2018_assign2matthewfader;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import static android.provider.MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


            public void buttonOne(View view) {
                Intent intent = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    byte REQUEST_IMAGE_CAPTURE = 0;
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
        }

        // Do something in response to button
    }
}
