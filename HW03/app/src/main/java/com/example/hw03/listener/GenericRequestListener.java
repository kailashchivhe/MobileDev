package com.example.hw03.listener;

import com.example.hw03.data.WeatherContainer;

import java.io.Reader;

public interface GenericRequestListener {
    void onFailure( String message );
    void onSuccess( Reader reader );
}
