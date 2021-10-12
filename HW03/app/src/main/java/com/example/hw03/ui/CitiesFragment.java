package com.example.hw03.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hw03.MainActivity;
import com.example.hw03.R;
import com.example.hw03.adapter.CityListAdaptor;
import com.example.hw03.data.Data;
import com.example.hw03.databinding.FragmentCitiesBinding;
import com.example.hw03.listener.FragmentChangeListener;

import java.util.ArrayList;

public class CitiesFragment extends Fragment {

    public static String TAG = "CitiesFragment";

    FragmentCitiesBinding fragmentCitiesBinding;

    public FragmentChangeListener fragmentChangeListener;

    ArrayList<Data.City> cities = new ArrayList<Data.City>();

    CityListAdaptor adaptor;

    public CitiesFragment() {
        // Required empty public constructor
    }

    public static CitiesFragment newInstance(String param1, String param2) {
        CitiesFragment fragment = new CitiesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cities = Data.cities;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        fragmentChangeListener = (MainActivity) context;
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle("Cities");

        adaptor =  new CityListAdaptor(getActivity(), R.layout.city_list_layout, cities);
        
        ListView cityListView = (ListView) fragmentCitiesBinding.cityListView;
        cityListView.setAdapter(adaptor);

        cityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                fragmentChangeListener.OnListItemClick(adaptor.getItem(i));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentCitiesBinding = FragmentCitiesBinding.inflate(inflater, container, false);

        return fragmentCitiesBinding.getRoot();
    }
}