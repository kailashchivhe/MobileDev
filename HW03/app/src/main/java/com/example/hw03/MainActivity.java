package com.example.hw03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.hw03.data.Data;
import com.example.hw03.listener.FragmentChangeListener;
import com.example.hw03.ui.CitiesFragment;
import com.example.hw03.ui.CurrentWeatherFragment;
import com.example.hw03.ui.WeatherForecastFragment;

public class MainActivity extends AppCompatActivity implements FragmentChangeListener {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        setCitiesFragment(new CitiesFragment());
    }

    void setCitiesFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace( R.id.mainActivityContainer, fragment, CitiesFragment.TAG )
                .commit();
    }

    void setCurrentWeatherFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .replace( R.id.mainActivityContainer, fragment, CurrentWeatherFragment.TAG )
                .addToBackStack(CurrentWeatherFragment.TAG)
                .commit();
    }

    void setWeatherForecastFragment(Fragment fragment) {
        fragmentManager.beginTransaction()
                .add( R.id.mainActivityContainer, fragment, WeatherForecastFragment.TAG )
                .addToBackStack(WeatherForecastFragment.TAG)
                .commit();
    }

    @Override
    public void OnListItemClick(Data.City city) {
        Fragment currentWeatherFragment = CurrentWeatherFragment.newInstance(city);
        setCurrentWeatherFragment(currentWeatherFragment);
    }

    @Override
    public void OnCheckForecastClick(Data.City city) {
        Fragment weatherForecastFragment = WeatherForecastFragment.newInstance(city);
        setWeatherForecastFragment(weatherForecastFragment);
    }
}