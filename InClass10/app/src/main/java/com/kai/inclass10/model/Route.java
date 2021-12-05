package com.kai.inclass10.model;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

public class Route {
    public List<LatLng> points;

    public Route(List<LatLng> points) {
        this.points = points;
    }
}
