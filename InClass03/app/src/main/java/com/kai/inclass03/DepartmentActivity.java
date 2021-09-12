package com.kai.inclass03;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class DepartmentActivity extends AppCompatActivity {

    RadioGroup mRadioGroup;
    Button mCancelButton;
    Button mSubmitButton;
    String mCurrentDepartment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        setTitle(R.string.department);
        mRadioGroup = findViewById( R.id.radioGroup );
        mCancelButton = findViewById( R.id.cancelButton );
        mSubmitButton = findViewById( R.id.selectButton );
        mCurrentDepartment = getString( R.string.radio_label_cs );
    }

    @Override
    protected void onResume() {
        super.onResume();
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch ( checkedId ){
                    case R.id.radioButtonBI:{
                        mCurrentDepartment = getString( R.string.radio_label_bi );
                        break;
                    }
                    case R.id.radioButtonCS:{
                        mCurrentDepartment = getString( R.string.radio_label_cs );
                        break;
                    }
                    case R.id.radioButtonDS:{
                        mCurrentDepartment = getString( R.string.radio_label_ds );
                        break;
                    }
                    case R.id.radioButtonSIS:{
                        mCurrentDepartment = getString( R.string.radio_label_sis );
                        break;
                    }
                }
            }
        });

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra( MainActivity.DEPARTMENT_KEY, mCurrentDepartment );
                setResult( RESULT_OK, intent );
                finish();
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult( RESULT_CANCELED, intent );
                finish();
            }
        });
    }
}