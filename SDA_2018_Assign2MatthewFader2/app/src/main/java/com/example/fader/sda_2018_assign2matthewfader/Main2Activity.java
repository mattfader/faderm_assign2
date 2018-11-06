package com.example.fader.sda_2018_assign2matthewfader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Main2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//this section was sourced from - https://www.youtube.com/watch?v=s3pheMAmaPI
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); 
    }
@Override
    public boolean onOptionsItemSelected(MenuItem item) 
    {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }




//This section was sourced from -
    public void button6(android.view.View view) {
        final int emailRequest = 1;


            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
            //startActivity(intent);
            startActivityForResult(intent, emailRequest);
        }
    }

