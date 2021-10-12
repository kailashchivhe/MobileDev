package com.example.hw03.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.hw03.R;
import com.example.hw03.data.Data;

import java.util.List;

public class CityListAdaptor extends ArrayAdapter<Data.City> {
    public CityListAdaptor(@NonNull Context context, int resourceId, @NonNull List<Data.City> objects) {
        super(context, resourceId, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Data.City city = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.city_list_layout, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.nameTextView);
        TextView country = (TextView) convertView.findViewById(R.id.countryTextView);

        name.setText(city.getCity());
        country.setText(city.getCountry());

        return convertView;
    }
}
