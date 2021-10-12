package com.example.hw03.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hw03.MainActivity;
import com.example.hw03.R;
import com.example.hw03.data.Data;
import com.example.hw03.databinding.FragmentWeatherForecastBinding;
import com.example.hw03.listener.FragmentChangeListener;

public class WeatherForecastFragment extends Fragment {

    public static String TAG = "WeatherForecastFragment";

    FragmentWeatherForecastBinding fragmentWeatherForecastBinding;

    public FragmentChangeListener fragmentChangeListener;

    private static final String ARG_PARAM = "param";

    private Data.City city;

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
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentChangeListener = (MainActivity) context;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Weather Forecast");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentWeatherForecastBinding = FragmentWeatherForecastBinding.inflate(inflater, container, false);

        return fragmentWeatherForecastBinding.getRoot();
    }
}