package com.example.myapp.lesson4;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/**
 * Created by konstantinaksenov on 06.10.14.
 */
public class GPSActivity extends Activity {

    private LocationManager locationManager;
    private LocationListener finelocationListener;
    private String fineProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setCostAllowed(false);
        fineProvider = locationManager.getBestProvider(criteria, true);
        finelocationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onProviderEnabled(String provider) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void onProviderDisabled(String provider) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        };
        locationManager.requestLocationUpdates(fineProvider, 5000, 0, finelocationListener);

    }
}
