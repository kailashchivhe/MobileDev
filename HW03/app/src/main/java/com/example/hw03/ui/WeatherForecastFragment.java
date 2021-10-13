package com.example.hw03.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw03.MainActivity;
import com.example.hw03.R;
import com.example.hw03.adapter.WeatherForecastListAdaptor;
import com.example.hw03.data.Data;
import com.example.hw03.data.DataServices;
import com.example.hw03.data.WeatherContainer;
import com.example.hw03.data.forecast.Forecast;
import com.example.hw03.data.forecast.ForecastContainer;
import com.example.hw03.databinding.FragmentWeatherForecastBinding;
import com.example.hw03.listener.FragmentChangeListener;
import com.example.hw03.listener.WeatherForecastListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WeatherForecastFragment extends Fragment {

    public static String TAG = "WeatherForecastFragment";

    FragmentWeatherForecastBinding fragmentWeatherForecastBinding;

    public FragmentChangeListener fragmentChangeListener;

    private static final String ARG_PARAM = "param";

    private Data.City city;

    private WeatherForecastListAdaptor weatherForecastListAdaptor;

    ArrayList<Forecast> forecastList;

    public WeatherForecastFragment() {
        // Required empty public constructor
    }

    public static WeatherForecastFragment newInstance(Data.City param) {
        WeatherForecastFragment fragment = new WeatherForecastFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM, param);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            city = (Data.City) getArguments().getSerializable(ARG_PARAM);
            DataServices.getWeatherForecast(city.getCity(), new WeatherForecastListener() {
                @Override
                public void onWeatherSuccess(WeatherContainer weatherContainer) {
                    //Do Nothing
                }

                @Override
                public void onForecastSuccess(ForecastContainer forecastContainer) {
                    initView( forecastContainer );
                }

                @Override
                public void onFailure(String message) {
                    showFailureMessage(message);
                }
            });
        }
    }

    private void showFailureMessage(String message) {
        new Handler( Looper.getMainLooper()).post(() -> {
            AlertDialog.Builder builder = new AlertDialog.Builder( getContext() );
            builder.setTitle( R.string.failure );
            builder.setMessage( message );
            builder.setCancelable( true );
            builder.show();
        });
    }

    private void initView( ForecastContainer forecastContainer) {
        new Handler( Looper.getMainLooper()).post(() -> {
            refreshList( forecastContainer.list );
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentChangeListener = (MainActivity) context;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.weather_forecast);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentWeatherForecastBinding = FragmentWeatherForecastBinding.inflate(inflater, container, false);
        forecastList = new ArrayList<>();
        weatherForecastListAdaptor = new WeatherForecastListAdaptor(forecastList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        fragmentWeatherForecastBinding.recyclerView.setLayoutManager( linearLayoutManager );
        fragmentWeatherForecastBinding.recyclerView.setAdapter(weatherForecastListAdaptor);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(fragmentWeatherForecastBinding.recyclerView.getContext(), linearLayoutManager.getOrientation());
        fragmentWeatherForecastBinding.recyclerView.addItemDecoration(dividerItemDecoration);
        fragmentWeatherForecastBinding.cityNameTextView.setText( city.getCity() );
        return fragmentWeatherForecastBinding.getRoot();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void refreshList(ArrayList<Forecast> forecastList ){
        this.forecastList = forecastList;
        weatherForecastListAdaptor.refreshData( forecastList );
        weatherForecastListAdaptor.notifyDataSetChanged();
    }
}