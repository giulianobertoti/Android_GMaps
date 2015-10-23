package com.example.giuliano.googlemaps;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Created by Giuliano on 06/10/2015.
 */
public class GPS implements LocationListener {

    private GoogleMap map;
    private List<Marker> otherMarkers;
    private Calculation calc = new Calculation();

    public GPS(GoogleMap map, List<Marker> markers){

        this.map = map;
        this.otherMarkers = markers;
    }

    @Override
    public void onLocationChanged(Location location) {

        Marker m = new Marker(location.getLatitude(), location.getLongitude(), "");
        Double distance = calc.CalculationByDistance(new LatLng(location.getLatitude(), location.getLongitude()), new LatLng(this.otherMarkers.get(0).getLat(), this.otherMarkers.get(0).getLon()));
        Integer km = distance.intValue();
        map.addMarker(new MarkerOptions().position(new LatLng(m.getLat(), m.getLon())).title("I am here, "+km.toString()+"km from "+this.otherMarkers.get(0).getDesc()));

    }
    @Override
    public void onProviderDisabled(String provider) {
    }
    @Override
    public void onProviderEnabled(String provider) {
    }
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }
}
