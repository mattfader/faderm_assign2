package com.example.fader.myactivityapp2018_matthewfader;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String TAG = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = findViewById(R.id.editText);

        Log.i(TAG, "<1st> this is where we assign the label to the variable of the same name");
        String message = editText.getText().toString();
        Log.i(TAG, "<1st> this is where we get the text from the editText field and store it in a var ");
        intent.putExtra(EXTRA_MESSAGE, message);
        Log.i(TAG, "this is where the message is passed to the intent");
        startActivity(intent);
        Log.i(TAG, "<1st> this is where the intent is passed to the DisplayMessageActivity");
    }
}
