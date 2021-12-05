package com.kai.inclass10.ui;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.kai.inclass10.R;
import com.kai.inclass10.adaptor.RecyclerViewAdaptor;
import com.kai.inclass10.databinding.FragmentHomeBinding;
import com.kai.inclass10.listener.RecyclerListener;
import com.kai.inclass10.listener.RouteListener;
import com.kai.inclass10.model.Route;
import com.kai.inclass10.sdk.FirebaseHelper;

import java.io.Serializable;
import java.util.ArrayList;

public class HomeFragment extends Fragment implements RouteListener, RecyclerListener {

    private FragmentHomeBinding binding;

    ArrayList<Route> logs;

    RecyclerViewAdaptor adaptor;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FirebaseHelper.getAllRoutes(this);

        binding.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_HomeFragment_to_jogFragment);
            }
        });

        binding.logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_HomeFragment_to_LoginFragment);
            }
        });
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onSuccess(ArrayList<Route> routeList) {
        logs = routeList;

        adaptor = new RecyclerViewAdaptor(logs, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        binding.logsRecyclerView.setLayoutManager( linearLayoutManager );
        binding.logsRecyclerView.setAdapter(adaptor);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(binding.logsRecyclerView.getContext(), linearLayoutManager.getOrientation());
        binding.logsRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public void onFailure(String message) {
        showFailureMessage(message);
    }

    private void showFailureMessage(String message) {
        new Handler( Looper.getMainLooper()).post(() -> {
            AlertDialog.Builder builder = new AlertDialog.Builder( getContext() );
            builder.setTitle( R.string.failure );
            builder.setMessage( message );
            builder.setCancelable( true );
            builder.show();
        });
    }

    @Override
    public void OnClick(Route route) {
        Bundle bundle = new Bundle();
        bundle.putSerializable( "route", (Serializable) route.points);
        NavHostFragment.findNavController( this ).navigate( R.id.action_HomeFragment_to_mapsActivity, bundle );
    }
}