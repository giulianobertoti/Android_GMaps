package com.example.giuliano.googlemaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;

import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private Connection con = new Connection();

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

        try {
            List<Marker> markers = con.getData();

            for(Marker marker:markers){
                map.addMarker(new MarkerOptions().position(new LatLng(marker.getLat(),marker.getLon())));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}