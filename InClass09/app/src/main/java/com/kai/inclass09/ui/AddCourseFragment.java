package com.kai.inclass09.ui;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.kai.inclass09.R;
import com.kai.inclass09.database.CourseTaken;
import com.kai.inclass09.database.RoomHelper;
import com.kai.inclass09.databinding.FragmentAddCourseBinding;


public class AddCourseFragment extends Fragment {

    FragmentAddCourseBinding fragmentAddCourseBinding;

    public static AddCourseFragment newInstance(String param1, String param2) {
        AddCourseFragment fragment = new AddCourseFragment();
        return fragment;
    }

    @Override
    public void onResume() {
        super.onResume();

        getActivity().setTitle(R.string.addT);

        fragmentAddCourseBinding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(getView()).popBackStack();
            }
        });

        fragmentAddCourseBinding.submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RoomHelper.init( getContext() );
                String number = fragmentAddCourseBinding.courseNumberInput.getText().toString();
                String name = fragmentAddCourseBinding.courseNameInput.getText().toString();
                double hours = fragmentAddCourseBinding.creditHoursInput.getText().toString().isEmpty() ? -1 : Integer.parseInt(fragmentAddCourseBinding.creditHoursInput.getText().toString());
                int grade_id = fragmentAddCourseBinding.radioGroup.getCheckedRadioButtonId();
                String grade;
                if(number.isEmpty() || name.isEmpty() || hours < 1 || grade_id == -1) {
                    showFailureMessage(getString(R.string.failure_msg));
                } else {
                    RadioButton button = (RadioButton) getActivity().findViewById(grade_id);
                    grade = button.getText().toString();

                    CourseTaken courseTaken = new CourseTaken();
                    courseTaken.courseTitle = name;
                    courseTaken.creditHours = hours;
                    courseTaken.CourseNumber = number;
                    courseTaken.letterGrade = grade;

                    RoomHelper.insert(courseTaken);

                    Navigation.findNavController(getView()).popBackStack();
                }

            }
        });
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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentAddCourseBinding = FragmentAddCourseBinding.inflate( inflater, container, false );
        return fragmentAddCourseBinding.getRoot();
    }
}