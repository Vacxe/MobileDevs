package com.example.myapp;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.myapp.lesson1.ButtonActions;

public class MainActivity extends Activity implements View.OnClickListener{
    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.lesson_one_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent startIntent = null;
        switch (v.getId()){
            case R.id.lesson_one_button:
                startIntent = new Intent(this, ButtonActions.class);
                break;
        }
        startActivity(startIntent);
    }
}
