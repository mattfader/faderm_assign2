package com.example.fader.myactivityapp2018_matthewfader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private static final String TAG =null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Log.i(TAG, "<2nd>this is where we define our intent from the other activity ");
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        Log.i(TAG, "<2nd>we take EXTRA_MESSAGE and store it into message var on this side");

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView2);
        Log.i(TAG, "<2nd>this is where we assign the textView2 attribute");
        textView.setText(message);
        Log.i(TAG, "<2nd>this is where pass the string text to the textView");
    }

}
