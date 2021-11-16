package com.kai.inclass09.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.kai.inclass09.R;
import com.kai.inclass09.adapter.RecyclerAdapter;
import com.kai.inclass09.database.CourseTaken;
import com.kai.inclass09.database.RoomHelper;
import com.kai.inclass09.databinding.FragmentHomeBinding;
import com.kai.inclass09.listeners.RecyclerViewListener;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements RecyclerViewListener {

    FragmentHomeBinding fragmentHomeBinding;

    List<CourseTaken> courses;

    RecyclerAdapter recyclerAdapter;

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu( true );
    }

    @Override
    public void onResume() {
        super.onResume();

        getActivity().setTitle(R.string.gradesT);

        RoomHelper.init( getContext() );
        courses = RoomHelper.getAllCourses();

        calculateGPA(courses);

        recyclerAdapter = new RecyclerAdapter(courses, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        fragmentHomeBinding.recyclerView.setLayoutManager( linearLayoutManager );
        fragmentHomeBinding.recyclerView.setAdapter(recyclerAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(fragmentHomeBinding.recyclerView.getContext(), linearLayoutManager.getOrientation());
        fragmentHomeBinding.recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void calculateGPA(List<CourseTaken> courses) {
        int total_credits = 0;
        double total_credit_hours = 0;
        NumberFormat formatter = new DecimalFormat("#0.00");
        for(int i=0; i < courses.size(); i++) {
            total_credits = (int) (total_credits + (courses.get(i).creditHours *
                                (courses.get(i).letterGrade.equals("A") ? 4 :
                                        courses.get(i).letterGrade.equals("B") ? 3 :
                                                courses.get(i).letterGrade.equals("C") ? 2 :
                                                        courses.get(i).letterGrade.equals("D") ? 1 : 0)));

            total_credit_hours = total_credit_hours + courses.get(i).creditHours;
        }
        fragmentHomeBinding.gpaTextView.setText("GPA: "+formatter.format(total_credits/total_credit_hours));
        fragmentHomeBinding.hoursTextView.setText("Hours: "+Math.round(total_credit_hours));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentHomeBinding = FragmentHomeBinding.inflate( inflater, container, false );
        return fragmentHomeBinding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate( R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if( item.getItemId() == R.id.action_add ){
            Navigation.findNavController( getView() ).navigate( R.id.action_homeFragment_to_addCourseFragment );
        }
        return true;
    }

    @Override
    public void onDeleteClicked(CourseTaken course) {
        RoomHelper.delete( course );

        courses = RoomHelper.getAllCourses();
        recyclerAdapter.refreshData( courses );
        recyclerAdapter.notifyDataSetChanged();

        calculateGPA(courses);
    }
}