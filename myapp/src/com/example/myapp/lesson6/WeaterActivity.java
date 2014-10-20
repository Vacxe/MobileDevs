package com.example.myapp.lesson6;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;
import com.example.myapp.R;
import com.nitrobubbles.AndroidAxeLib.Internet.AsyncDataFetcher;
import com.nitrobubbles.AndroidAxeLib.Internet.DataFetcherInterface;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by konstantinaksenov on 20.10.14.
 */
public class WeaterActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weateractivity);
        String url = "http://api.openweathermap.org/data/2.5/find?lat=55&lon=37.5&cnt=20";
        final AsyncDataFetcher dataFetcher = new AsyncDataFetcher(url, new DataFetcherInterface<JSONObject>() {
            @Override
            public void startLoading() {

            }

            @Override
            public void result(JSONObject echo) {
                Log.e("Echo", echo.toString());
                try {
                    JSONArray listArray = echo.getJSONArray("list");
                    for(int i = 0; i <listArray.length();i++){
                       JSONObject weaterObject = listArray.getJSONObject(i);
                       JSONObject main = weaterObject.getJSONObject("main");
                       double temp = main.getDouble("temp")-273.0;
                       Toast.makeText(WeaterActivity.this,String.valueOf(temp), Toast.LENGTH_SHORT).show();
                      }

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }


            @Override
            public void finishLoading() {

            }

            @Override
            public void error(String error) {

            }
        });

        AlertDialog.Builder dialog = new AlertDialog.Builder(WeaterActivity.this);
        dialog.setTitle("You wanna load rest api?");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                 dataFetcher.execute();
            }
        });

        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.setCancelable(false);
        dialog.create().show();

    }
}
