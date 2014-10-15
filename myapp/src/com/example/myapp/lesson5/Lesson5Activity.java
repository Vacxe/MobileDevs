package com.example.myapp.lesson5;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import com.example.myapp.R;
import com.nitrobubbles.AndroidAxeLib.Internet.AsyncDataFetcher;
import com.nitrobubbles.AndroidAxeLib.Internet.DataFetcherInterface;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by konstantinaksenov on 13.10.14.
 */
public class Lesson5Activity extends FragmentActivity {
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String echo = intent.getExtras().getString("echo");
            try {
                JSONObject jsonObject =new JSONObject(echo);
                //TODO: PARSE OBJECT, READ JSONOBJECT DOCUMENTATION
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lesson5activity);
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).memoryCache(new LruMemoryCache(32 * 1024 * 1024))
                .memoryCacheSize(32 * 1024 * 1024)
                .discCacheSize(100 * 1024 * 1024)
                .discCacheFileCount(1000).build();
        ImageLoader.getInstance().init(config);
        ImageLoader.getInstance().displayImage("http://simple.png",(ImageView)findViewById(R.id.imageView));
       
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter("WEATHER_UPDATE"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
