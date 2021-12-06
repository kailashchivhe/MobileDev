package com.kai.inclass10.model;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class Route implements Serializable {
    public List<HashMap<String,Double>> points;

    public Route(List<HashMap<String,Double>> points) {
        this.points = points;
    }
}
