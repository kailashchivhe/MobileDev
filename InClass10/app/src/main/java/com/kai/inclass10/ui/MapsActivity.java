package com.kai.inclass10.ui;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;
import com.kai.inclass10.R;
import com.kai.inclass10.databinding.ActivityMapsBinding;
import com.kai.inclass10.model.Point;
import com.kai.inclass10.model.Route;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/*
* Name: Kailash Chivhe & Ankit Vaity
* Assignment: HW07
* file: MapsActivity
* */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng> routeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        com.kai.inclass10.databinding.ActivityMapsBinding binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if( savedInstanceState != null ){
            routeList = savedInstanceState.getParcelableArrayList("route" );
        }

        if( mapFragment != null ) {
            mapFragment.getMapAsync(this);
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if( routeList != null ) {
            LatLng start = new LatLng(routeList.get(0).latitude, routeList.get(0).longitude);
            LatLng end = new LatLng(routeList.get(routeList.size()-1).latitude, routeList.get(routeList.size()-1).longitude);
            mMap.addMarker( new MarkerOptions().position(start).title("Start") );
            mMap.addMarker( new MarkerOptions().position(end).title("End") );

            LatLngBounds.Builder builder = new LatLngBounds.Builder();

            PolylineOptions options = new PolylineOptions().width(10).color(Color.BLUE).geodesic(true);
            for(LatLng point: routeList){
                LatLng latLng = new LatLng( point.latitude, point.longitude );
                options.add( latLng );
                builder.include( latLng );
            }

            mMap.addPolyline( options );

            int padding = 50;
            LatLngBounds bounds = builder.build();
            final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
            mMap.setOnMapLoadedCallback(() -> mMap.animateCamera(cu));
        }
    }
}