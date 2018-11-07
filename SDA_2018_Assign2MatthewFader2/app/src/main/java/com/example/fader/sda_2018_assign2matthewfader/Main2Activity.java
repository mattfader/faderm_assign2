package com.example.fader.sda_2018_assign2matthewfader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import static com.example.fader.sda_2018_assign2matthewfader.R.id.editText;
import static com.example.fader.sda_2018_assign2matthewfader.R.id.editText2;
import static com.example.fader.sda_2018_assign2matthewfader.R.id.editText3;
import static com.example.fader.sda_2018_assign2matthewfader.R.id.textView;

public class Main2Activity extends AppCompatActivity {


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
        int emailRequest = 0;

        EditText editText1 = this.findViewById(R.id.editText);
        String textView1 = editText1.getText().toString();
        EditText editText2 = this.findViewById(R.id.editText2);
        String textView2 = editText2.getText().toString();
        EditText editText3 = this.findViewById(R.id.editText3);
        String textView3 = editText3.getText().toString();

        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        //Intent intent = new Intent();
        intent.putExtra("email", textView1);
        intent.putExtra("subject", textView2);
        intent.putExtra("content",textView3);

        setResult(Main2Activity.RESULT_OK, intent);





        }
    }




