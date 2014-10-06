package com.example.myapp.lesson4;

import android.app.Activity;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.preference.PreferenceManager;

/**
 * Created by konstantinaksenov on 06.10.14.
 */
public class SharedPreferenceActivity extends Activity implements SensorEventListener {
    private static final String STORED_STRING = "Stored_String";
    static SharedPreferences preferences;
    String[] cart;

    private SensorManager sensorManager;
    double ax,ay,az;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor acc = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sensorManager.registerListener(this, acc, SensorManager.SENSOR_DELAY_NORMAL);


        SensorManager mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        Sensor orientationSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        mSensorManager.registerListener(this, orientationSensor, SensorManager.SENSOR_DELAY_NORMAL);


        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        cart = getCartString().split("-");

       StringBuilder builder = new StringBuilder("");

        for(String cardItem : cart){
           builder.append(cardItem);
            builder.append("-");
        }
        builder.deleteCharAt(builder.length()-1);
        setCardItem(builder.toString());
    }

    public static void setCardItem(String token) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(STORED_STRING, token);
        editor.commit();
    }

    public static String getCartString() {
        return preferences.getString(STORED_STRING, "бананы-кокосы-апельсины");

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType()==Sensor.TYPE_ACCELEROMETER){
            ax=event.values[0];
            ay=event.values[1];
            az=event.values[2];
        }else if(event.sensor.getType()==Sensor.TYPE_ORIENTATION){
             float azimuthInDegrees = event.values[0];
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
