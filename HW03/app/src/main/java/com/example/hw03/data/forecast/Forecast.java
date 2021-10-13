package com.example.hw03.data.forecast;

import com.example.hw03.data.Clouds;
import com.example.hw03.data.Weather;
import com.example.hw03.data.Wind;

import java.util.ArrayList;

public class Forecast {
    public int dt;
    public Main main;
    public ArrayList<Weather> weather;
    public Clouds clouds;
    public Wind wind;
    public int visibility;
    public double pop;
    public Sys sys;
    public String dt_txt;
    public Rain rain;
}
