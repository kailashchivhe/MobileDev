package com.kai.inclass10.model;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.List;

public class Route implements Serializable {
    public List<LatLng> points;

    public Route(List<LatLng> points) {
        this.points = points;
    }
}
