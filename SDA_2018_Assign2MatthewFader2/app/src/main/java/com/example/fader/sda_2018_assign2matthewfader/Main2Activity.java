package com.example.fader.sda_2018_assign2matthewfader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    static final int emailRequest = 1;
    public void startMainActivity(View view) {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        //startActivity(intent);
        startActivityForResult(intent, emailRequest);
    }
}
