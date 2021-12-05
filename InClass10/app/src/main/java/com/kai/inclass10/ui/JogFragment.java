package com.kai.inclass10.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.kai.inclass10.R;
import com.kai.inclass10.databinding.FragmentJogBinding;
import com.kai.inclass10.sdk.FirebaseHelper;

import java.util.ArrayList;


public class JogFragment extends Fragment {

    private static final int LOCATION_REQUEST_CODE = 100;
    FusedLocationProviderClient fusedLocationProviderClient;
    LocationRequest locationRequest;
    ArrayList<LatLng> arrayList = new ArrayList<>();
    FragmentJogBinding fragmentJogBinding;

    LocationCallback locationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(@NonNull LocationResult locationResult) {
            LatLng latLng = new LatLng( locationResult.getLastLocation().getLatitude(), locationResult.getLastLocation().getLongitude() );
            if(!arrayList.contains(latLng)){
                arrayList.add(latLng);
            }
        }
    };

    public static JogFragment newInstance(String param1, String param2) {
        JogFragment fragment = new JogFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient( getActivity() );
        locationRequest = com.google.android.gms.location.LocationRequest.create();
        locationRequest.setInterval(2500);
        locationRequest.setFastestInterval(1000);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentJogBinding = FragmentJogBinding.inflate( inflater, container, false );
        return fragmentJogBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        fragmentJogBinding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startLocationUpdates();
            }
        });

        fragmentJogBinding.currentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToMap();
            }
        });

        fragmentJogBinding.stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopLocationUpdates();
                FirebaseHelper.addRoute( arrayList );
            }
        });
    }

    private void navigateToMap(){
        Bundle bundle = new Bundle();
        bundle.putSerializable( "route", arrayList );
        NavHostFragment.findNavController( this ).navigate( R.id.action_jogFragment_to_mapsActivity, bundle );
    }
    @Override
    public void onStart() {
        super.onStart();
        if( ContextCompat.checkSelfPermission( getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ){
            askForLocationPermission();
        }
    }

    private void checkSettingsAndStartLocationUpdates() {
        LocationSettingsRequest request = new LocationSettingsRequest.Builder().addLocationRequest( locationRequest ).build();
        SettingsClient settingsClient = LocationServices.getSettingsClient( getActivity() );

        Task<LocationSettingsResponse> locationSettingsResponseTask = settingsClient.checkLocationSettings(request);
        locationSettingsResponseTask.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {
            @Override
            public void onComplete(@NonNull Task<LocationSettingsResponse> task) {
                if(task.isSuccessful()){
                    //TASK completed
                }
            }
        });
    }

    private void startLocationUpdates() {
        arrayList.clear();
        fusedLocationProviderClient.requestLocationUpdates( locationRequest, locationCallback, Looper.getMainLooper() );
    }

    private void stopLocationUpdates() {
        fusedLocationProviderClient.removeLocationUpdates(locationCallback);
        //Add array to firebase
    }

    private void askForLocationPermission() {
        if( ContextCompat.checkSelfPermission( getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ){
            if(ActivityCompat.shouldShowRequestPermissionRationale( getActivity(), Manifest.permission.ACCESS_FINE_LOCATION ) ){
                ActivityCompat.requestPermissions( getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE );
            }
            else{
                ActivityCompat.requestPermissions( getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CODE );
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == LOCATION_REQUEST_CODE && grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            checkSettingsAndStartLocationUpdates();
        }
        else{
            askForLocationPermission();
        }
    }
}