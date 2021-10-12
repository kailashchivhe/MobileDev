package com.example.hw03.listener;

import com.example.hw03.data.Data;

public interface FragmentChangeListener {
    void OnListItemClick(Data.City item);
    void OnCheckForecastClick(Data.City city);
}
