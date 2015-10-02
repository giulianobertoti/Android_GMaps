package com.example.giuliano.googlemaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        //obter o mapa da view
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        //set o callback
        mapFragment.getMapAsync(this);
    }


    //metodo callback
    @Override
    public void onMapReady(GoogleMap map) {
        LatLng fatecSJC = new LatLng(-23.162390, -45.795432);
        map.addMarker(new MarkerOptions().position(fatecSJC).title("FATEC São José"));
        map.moveCamera(CameraUpdateFactory.newLatLng(fatecSJC));
    }
}