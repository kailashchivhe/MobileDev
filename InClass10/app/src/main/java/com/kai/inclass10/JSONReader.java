package com.kai.inclass10;

import android.content.Context;

import com.google.gson.Gson;
import com.kai.inclass10.model.Route;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSONReader {
    public static Route readAssets(Context context){
        try
        {
            InputStream inputStream = context.getAssets().open("trip.json");
            BufferedReader bufferedReader = new BufferedReader( new InputStreamReader( inputStream ) );
            Gson gson = new Gson();
            return gson.fromJson( bufferedReader, Route.class );
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        return null;
    }
}
