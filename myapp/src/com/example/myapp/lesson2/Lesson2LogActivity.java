package com.example.myapp.lesson2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.myapp.R;

import java.lang.annotation.Annotation;

/**
 * Created by konstantinaksenov on 22.09.14.
 */
public class Lesson2LogActivity extends Activity {
    private static final String TAG = "TAGTAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_activity);
        final LinearLayout buttonLayout = (LinearLayout) findViewById(R.id.button_layout);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "TOAST!", Toast.LENGTH_LONG).show();
                Button button = new Button(getApplicationContext());
                buttonLayout.addView(button);
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "LOG WITH CLICK");

                AlphaAnimation animatiomn = new AlphaAnimation(0f, 1f);
                animatiomn.setDuration(5000);
                animatiomn.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(getApplicationContext(), "Start", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

                        Toast.makeText(getApplicationContext(), "Ended", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                v.startAnimation(animatiomn);

                //Clear all childs
                buttonLayout.removeAllViews();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("MENU 1");
        menu.add("MENU 2");
        menu.add("MENU 3");
        menu.add("MENU 4");
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
        switch (item.getItemId()){
            case R.id.menu1:
                break;
        }
        return super.onMenuItemSelected(featureId, item);
    }
}
