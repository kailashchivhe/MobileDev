package com.kai.inclass10.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.kai.inclass10.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MapsFragment extends Fragment {

    private GoogleMap mMap;
    ArrayList<HashMap<String,Double>> routeList;

    private OnMapReadyCallback callback = new OnMapReadyCallback() {
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;
            if( routeList != null && routeList.size() > 2 ) {
                LatLng start = new LatLng(routeList.get(0).get("latitude"), routeList.get(0).get("longitude"));
                LatLng end = new LatLng(routeList.get(routeList.size()-1).get("latitude"), routeList.get(routeList.size()-1).get("longitude"));
                mMap.addMarker( new MarkerOptions().position(start).title("Start") );
                mMap.addMarker( new MarkerOptions().position(end).title("End") );

                PolylineOptions options = new PolylineOptions().width(10).color(Color.BLUE).geodesic(true);
                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                for(HashMap<String,Double> point: routeList){
                    LatLng latLng = new LatLng( point.get("latitude"), point.get("longitude") );
                    options.add( latLng );
                    builder.include( latLng );
                }

                mMap.addPolyline( options );
                int padding = 50;
                LatLngBounds bounds = builder.build();
                final CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);
                mMap.setOnMapLoadedCallback(() -> mMap.animateCamera(cu));
            }
            else{
                Toast.makeText( getContext(), R.string.need_more_points, Toast.LENGTH_LONG ).show();
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);

        Bundle bundle = getArguments();
        if(bundle != null ){
            routeList = (ArrayList<HashMap<String,Double>>) bundle.getSerializable("route" );
        }
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }
}