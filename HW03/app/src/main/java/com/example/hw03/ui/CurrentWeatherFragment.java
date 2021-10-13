package com.example.hw03.ui;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw03.MainActivity;
import com.example.hw03.R;
import com.example.hw03.data.Data;
import com.example.hw03.data.DataServices;
import com.example.hw03.data.WeatherContainer;
import com.example.hw03.data.forecast.ForecastContainer;
import com.example.hw03.databinding.FragmentCitiesBinding;
import com.example.hw03.databinding.FragmentCurrentWeatherBinding;
import com.example.hw03.listener.FragmentChangeListener;
import com.example.hw03.listener.WeatherForecastListener;
import com.squareup.picasso.Picasso;

public class CurrentWeatherFragment extends Fragment {

    public static String TAG = "CurrentWeatherFragment";

    FragmentCurrentWeatherBinding fragmentCurrentWeatherBinding;

    public FragmentChangeListener fragmentChangeListener;

    private static final String ARG_PARAM = "param";

    private Data.City city;

    private WeatherForecastListener weatherForecastListener;

    public CurrentWeatherFragment() {
        // Required empty public constructor
    }

    public static CurrentWeatherFragment newInstance(Data.City param) {
        CurrentWeatherFragment fragment = new CurrentWeatherFragment();
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

    @SuppressLint("SetTextI18n")
    private void initView(WeatherContainer weatherContainer) {
        new Handler( Looper.getMainLooper()).post(() -> {
            fragmentCurrentWeatherBinding.cityNameTextView.setText( city.getCity() );
            fragmentCurrentWeatherBinding.descriptionTextView.setText( weatherContainer.weather.get(0).description);
            fragmentCurrentWeatherBinding.temperatureTextView.setText( ""+ DataServices.df1.format(DataServices.getFahrenheit(weatherContainer.main.temp ) ) + " F" );
            fragmentCurrentWeatherBinding.temperatureMaxTextView.setText( ""+ DataServices.df1.format(DataServices.getFahrenheit(weatherContainer.main.temp_max)) + " F" );
            fragmentCurrentWeatherBinding.temperatureMinTextView.setText( ""+ DataServices.df1.format(DataServices.getFahrenheit(weatherContainer.main.temp_min)) + " F" );
            fragmentCurrentWeatherBinding.humidityTextView.setText( ""+ weatherContainer.main.humidity + " %");
            fragmentCurrentWeatherBinding.windSpeedTextView.setText( ""+ weatherContainer.wind.speed + " miles/hr");
            fragmentCurrentWeatherBinding.windDegreeTextView.setText( ""+ weatherContainer.wind.deg + " degrees" );
            fragmentCurrentWeatherBinding.cloudinessTextView.setText( ""+ weatherContainer.clouds.all + " %");
            Picasso.get()
                    .load( DataServices.getIconURL( weatherContainer.weather.get(0).icon ) )
                    .placeholder( R.drawable.weather_placeholder )
                    .into( fragmentCurrentWeatherBinding.forecastImage );
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
        getActivity().setTitle(R.string.current_weather);
        fragmentCurrentWeatherBinding.checkForecastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentChangeListener.OnCheckForecastClick(city);
            }
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCurrentWeatherBinding = FragmentCurrentWeatherBinding.inflate(inflater, container, false);
        DataServices.getCurrentWeather(city.getCity(), new WeatherForecastListener() {
            @Override
            public void onWeatherSuccess(WeatherContainer weatherContainer) {
                initView( weatherContainer );
            }

            @Override
            public void onForecastSuccess(ForecastContainer forecastContainer) {
                //Do nothing
            }

            @Override
            public void onFailure(String message) {
                showFailureMessage(message);
            }
        });
        return fragmentCurrentWeatherBinding.getRoot();
    }
}