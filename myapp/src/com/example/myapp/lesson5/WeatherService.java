package com.example.myapp.lesson5;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.nitrobubbles.AndroidAxeLib.Internet.AsyncDataFetcher;
import com.nitrobubbles.AndroidAxeLib.Internet.DataFetcherInterface;
import org.json.JSONObject;


/**
 * Created by konstantinaksenov on 13.10.14.
 */
public class WeatherService extends Service {
    Handler handler;
    android.os.Handler.Callback callback = new android.os.Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            getWeather();
            handler.sendEmptyMessageDelayed(1,60*1000);
            return false;
        }
    };
    @Override
    public IBinder onBind(Intent intent) {
        handler = new Handler(callback);
        handler.sendEmptyMessageDelayed(1, 60 * 1000);
        return null;
    }

    void getWeather(){
        AsyncDataFetcher dataFetcher = new AsyncDataFetcher(requestUrl(), new DataFetcherInterface<JSONObject>() {


            @Override
            public void startLoading() {

            }

            @Override
            public void result(JSONObject echo) {
                Intent intent = new Intent("WEATHER_UPDATE");
                intent.putExtra("echo", echo.toString());
                sendBroadcast(intent);
            }

            @Override
            public void finishLoading() {

            }


            @Override
            public void error(String error) {

            }



        });
        dataFetcher.execute();
    }

    private String requestUrl(){
        return String.format("http://api.openweathermap.org/data/2.5/find?lat=55.5&lon=37.5&cnt=20");
    }
}
