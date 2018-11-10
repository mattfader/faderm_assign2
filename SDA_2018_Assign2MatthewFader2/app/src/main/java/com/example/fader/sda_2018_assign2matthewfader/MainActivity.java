package com.example.fader.sda_2018_assign2matthewfader;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

import static android.content.Intent.EXTRA_CONTENT_ANNOTATIONS;
import static android.content.Intent.EXTRA_EMAIL;
import static android.content.Intent.EXTRA_SUBJECT;

//import android.R;


@TargetApi(Build.VERSION_CODES.O)
@RequiresApi(api = Build.VERSION_CODES.O)
public class MainActivity extends AppCompatActivity {
    private static final String TAG = null; //tag var made for all the logs
    public int requestCode;
    public int resultCode;
    private EditText mEditTextTo;
    private EditText mEditTextSubject;
    private EditText mEditTextMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    static final int REQUEST_CODE = 1;

    public void button2(View view) {
    // this code is sourced from
        Intent intent1 = new Intent(Intent.ACTION_GET_CONTENT);
        intent1.setType("image/*");
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent1, REQUEST_IMAGE_GET);
        }
    }


    /*
    This is the button to loads the activity 2 page with the text fields to fill in.
    This info is sourced from the course text/videos
    */
    static final int REQUEST_EMAIL_GET = 1;  // The request code

    public void button3(View view) {
        Intent pickStringsIntent = new Intent(this, Main2Activity.class);
        //if (pickStringsIntent.resolveActivity(getPackageManager()) != null) {
        startActivityForResult(pickStringsIntent, REQUEST_EMAIL_GET);
        /*
        unused code, unstable app
        Button buttonNew = findViewById(R.id.button6);
        buttonNew.setOnClickListener(new View.OnClickListener() {
    public void displayMe(View v) {
        */
        Intent intent = getIntent();
        Log.i(TAG, "<2nd>this is where we define our intent from the other activity ");
        String message = intent.getStringExtra(Main2Activity.EXTRA_MESSAGE);
        Log.i(TAG, "<2nd>we take EXTRA_MESSAGE and store it into message var on this side");


        // Capture the TextView and set the string to a var
        TextView textView = findViewById(R.id.textView);
        Log.i(TAG, "<2nd>this is where we assign the textView2 attribute");
        textView.setText(message);
        Log.i(TAG, "<2nd>this is where pass the string text to the textView");
        setResult(Activity.RESULT_OK, intent);
        //!!!!the behavior is odd the textView only updates when you click on the "Explicit intent button a second time!!!!

    }


// email client code sourced at - https://www.youtube.com/watch?v=tZ2YEw6SoBU
    public void Blank (View view) {
        mEditTextTo = findViewById(R.id.editText);
        mEditTextSubject = findViewById(R.id.editText2);
        mEditTextMessage = findViewById(R.id.editText3);
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            { sendMail(); } // initialize sendMail method

            private void sendMail() {
                String address = mEditTextTo.getText().toString();
                String[] email = address.split(",");// this splits the string of address so to allow for more than one email to be whiten at once
                String sub = mEditTextSubject.getText().toString();
                String message = mEditTextMessage.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, email);
                intent.putExtra(Intent.EXTRA_SUBJECT, sub);
                intent.putExtra(Intent.EXTRA_TEXT, message);
                intent.setType("message/rfc822");
                Log.i(TAG, "<1st> make it to the start activity call");
                startActivity(Intent.createChooser(intent,"Choose Your Email Client Please!"));
            }


        });
    }
}