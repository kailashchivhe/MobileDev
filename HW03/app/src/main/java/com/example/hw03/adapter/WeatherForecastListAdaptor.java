package com.example.hw03.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hw03.R;
import com.example.hw03.data.DataServices;
import com.example.hw03.data.forecast.Forecast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class WeatherForecastListAdaptor extends RecyclerView.Adapter<WeatherForecastListAdaptor.ViewHolder> {

    private ArrayList<Forecast> list;

    public WeatherForecastListAdaptor(ArrayList<Forecast> forecastList){
        list = forecastList;
    }

    @NonNull
    @Override
    public WeatherForecastListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.forecast_list_layout, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull WeatherForecastListAdaptor.ViewHolder holder, int position) {
        Forecast forecast = list.get( position );
        holder.dateTextView.setText( forecast.dt_txt );
        holder.temperatureTextView.setText( ""+forecast.main.temp + "F" );
        holder.maxTemp.setText( "" + forecast.main.temp_max + "F" );
        holder.minTemp.setText( "" + forecast.main.temp_min + "F" );
        holder.humidity.setText( "" + forecast.main.humidity );
        holder.description.setText( forecast.weather.get(0).description );
        Picasso.get().load( DataServices.getIconURL( forecast.weather.get(0).icon ) )
                .placeholder( R.drawable.weather_placeholder )
                .into( holder.imageView );
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void refreshData(ArrayList<Forecast> forecastList){
        list = forecastList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView dateTextView;
        private final TextView temperatureTextView;
        private final TextView maxTemp;
        private final TextView minTemp;
        private final TextView humidity;
        private final TextView description;
        private final ImageView imageView;

        public ViewHolder(@NonNull View view) {
            super(view);
            dateTextView = (TextView) view.findViewById(R.id.dateTimeListTextView);
            temperatureTextView = (TextView) view.findViewById(R.id.temperatureListTextView);
            maxTemp = (TextView) view.findViewById(R.id.maxTempListTextView);
            minTemp = (TextView) view.findViewById(R.id.minTempListTextView);
            humidity = (TextView) view.findViewById(R.id.humidityListTextView);
            description = (TextView) view.findViewById(R.id.descriptionListTextView);
            imageView = (ImageView) view.findViewById(R.id.forecast_Image);
        }
    }
}
