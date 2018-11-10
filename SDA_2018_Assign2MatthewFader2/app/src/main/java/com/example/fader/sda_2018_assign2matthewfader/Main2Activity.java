package com.example.fader.sda_2018_assign2matthewfader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;
//import android.R;

public class Main2Activity extends AppCompatActivity {


    private static final String TAG = null;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
//this section was sourced from - https://www.youtube.com/watch?v=s3pheMAmaPI
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }


    //This section was sourced from -https://www.youtube.com/watch?v=XV27kPIXx9o
    public void button6(View view) {
        EditText editText1 = findViewById(R.id.editText);
        String textView1 = "To: "+ editText1.getText().toString()+"\n";
        EditText editText2 = this.findViewById(R.id.editText2);
        String textView2 = "Subject "+editText2.getText().toString()+"\n";
        EditText editText3 = this.findViewById(R.id.editText3);
        String textView3 = editText3.getText().toString();


        Intent intent = new Intent(this, MainActivity.class);
        //EditText editText = findViewById(R.id.editText);

        Log.i(TAG, "<1st> this is where we assign the label to the variable of the same name");
        //String message = editText.getText().toString();
        Log.i(TAG, "<1st> this is where we get the text from the editText field and store it in a var ");
        intent.putExtra(EXTRA_MESSAGE, textView1+textView2+textView3);
        Log.i(TAG, "this is where the message is passed to the intent");
        startActivity(intent);
        Log.i(TAG, "<1st> this is where the intent is passed to the DisplayMessageActivity");
    }
}