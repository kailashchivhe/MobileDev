package com.example.hw03.data;

import com.example.hw03.listener.GenericRequestListener;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DataServices {
    public static void getCurrentWeather(String cityName, GenericRequestListener genericRequestListener) {
        String url = "api.openweathermap.org/data/2.5/weather?q="+cityName+"&appid=3d4037b37b01c6173bd4b806e5d32f5c";

        getResponse(url, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                genericRequestListener.onFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                genericRequestListener.onSuccess( reader );
            }
        });
    }

    public static void getWeatherForecast(String cityName, GenericRequestListener genericRequestListener) {
        String url = "api.openweathermap.org/data/2.5/forecast?q="+cityName+"&appid=3d4037b37b01c6173bd4b806e5d32f5c";

        getResponse(url, new GenericRequestListener() {
            @Override
            public void onFailure(String message) {
                genericRequestListener.onFailure( message );
            }

            @Override
            public void onSuccess(Reader reader) {
                genericRequestListener.onSuccess( reader );
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
}
