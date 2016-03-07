package com.example.carlosmc.labo102;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends FragmentActivity {

    private GoogleMap mMap;
    private CameraUpdate mCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpMapIfNeeded();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private void setUpMapIfNeeded() {
        if (mMap == null) {
            mMap = ((SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map)).getMap();
            if (mMap != null) {

                    mMap.setMyLocationEnabled(true);

                setUpMap();
            }
        }
    }

    public void setUpMap() {
        mMap.addMarker(new MarkerOptions().position(new LatLng(-12.017124,
                -77.050744)).title("Facultad de Ciencias"));
        mCamera = CameraUpdateFactory.newLatLngZoom(new LatLng(
                -12.017124, -77.050744), 0);
        mMap.animateCamera(mCamera);
    }

}
