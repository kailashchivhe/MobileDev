package com.kai.inclass09.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kai.inclass09.R;
import com.kai.inclass09.database.CourseTaken;
import com.kai.inclass09.listeners.RecyclerViewListener;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>  {

    private List<CourseTaken> courseTakenArrayList;
    private RecyclerViewListener recyclerViewListener;
    public RecyclerAdapter(List<CourseTaken> courseTakenArrayList, RecyclerViewListener recyclerViewListener){
        this.courseTakenArrayList = courseTakenArrayList;
        this.recyclerViewListener = recyclerViewListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setIsRecyclable( false );
        CourseTaken course = courseTakenArrayList.get( position );
        holder.gradeTextView.setText( course.letterGrade );
        holder.courseIdTextView.setText( course.CourseNumber );
        holder.courseNameTextView.setText( course.courseTitle );
        holder.creditHoursTextView.setText( Math.round(course.creditHours) + " Credit Hours" );

        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerViewListener.onDeleteClicked(course);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courseTakenArrayList.size();
    }

    public void refreshData(List<CourseTaken> objectList){
        courseTakenArrayList = objectList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView gradeTextView;
        TextView courseIdTextView;
        TextView courseNameTextView;
        TextView creditHoursTextView;
        ImageView deleteButton;
        public ViewHolder(@NonNull View view) {
            super(view);
            gradeTextView = (TextView) view.findViewById(R.id.gradeTextView);
            courseIdTextView = (TextView) view.findViewById(R.id.courseIdTextView);
            courseNameTextView = (TextView) view.findViewById(R.id.courseNameTextView);
            creditHoursTextView = (TextView) view.findViewById(R.id.creditHoursTextView);
            deleteButton = (ImageView) view.findViewById(R.id.deleteButton);
        }
    }
}
