package com.kai.inclass10.listener;

import com.kai.inclass10.model.Route;

import java.util.ArrayList;

public interface RouteListener {
    void onSuccess(ArrayList<Route> routeList);
    void onFailure(String message);
}
