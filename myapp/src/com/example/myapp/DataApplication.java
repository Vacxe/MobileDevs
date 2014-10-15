package com.example.myapp;

import android.app.Application;
import android.content.Intent;
import com.example.myapp.lesson5.WeatherService;

/**
 * Created by konstantinaksenov on 13.10.14.
 */
public class DataApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        startService(new Intent(this, WeatherService.class));
    }
}
