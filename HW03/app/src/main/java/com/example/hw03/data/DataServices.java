package com.example.hw03.data;

import com.example.hw03.data.forecast.ForecastContainer;
import com.example.hw03.listener.GenericRequestListener;
import com.example.hw03.listener.WeatherForecastListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataServices {
    public static void getCurrentWeather(String cityName, WeatherForecastListener weatherForecastListener) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=3d4037b37b01c6173bd4b806e5d32f5c";

        getResponse(url, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                weatherForecastListener.onFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                weatherForecastListener.onWeatherSuccess( getWeather( reader) );
            }
        });
    }

    public static void getWeatherForecast(String cityName, WeatherForecastListener weatherForecastListener) {
        String url = "https://api.openweathermap.org/data/2.5/forecast?q="+cityName+"&appid=3d4037b37b01c6173bd4b806e5d32f5c";

        getResponse(url, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                weatherForecastListener.onFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                weatherForecastListener.onForecastSuccess( getForecast( reader ) );
            }
        });
    }

    private static void getResponse(String url, GenericRequestListener genericRequestListener ){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url( url )
                .build();

        client.newCall( request ).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                genericRequestListener.onFailure( e.getMessage() );
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                if( response.isSuccessful() ) {
                    genericRequestListener.onSuccess(response.body().charStream());
                }
                else
                {
                    genericRequestListener.onFailure( response.message() );
                }
            }
        });
    }

    private static WeatherContainer getWeather(Reader reader )
    {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson( reader, WeatherContainer.class );
    }

    private static ForecastContainer getForecast(Reader reader )
    {
        Gson gson = new GsonBuilder().create();
        return gson.fromJson( reader, ForecastContainer.class );
    }

    public static String getIconURL(String icon){
        return "http://openweathermap.org/img/wn/"+icon+"@2x.png";
    }
}
