package com.example.hw03.listener;

import com.example.hw03.data.WeatherContainer;
import com.example.hw03.data.forecast.ForecastContainer;

public interface WeatherForecastListener {
    void onWeatherSuccess(WeatherContainer weatherContainer );
    void onForecastSuccess(ForecastContainer forecastContainer);
    void onFailure(String message);
}
