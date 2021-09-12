package com.kai.inclass03;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
* Assignment: In Class 03
* File Name: MainActivity
* Name: Kailash Chivhe
* */
public class MainActivity extends AppCompatActivity {

    public static final String DEPARTMENT_KEY = "Department";
    public static final String PROFILE_KEY = "Profile";
    public static final int DEPARTMENT_REQUEST_CODE = 100;

    Button mSelectButton;
    Button mSubmitButton;
    EditText mName;
    EditText mEmail;
    EditText mId;
    TextView mDepartmentTextView;
    String mDepartmentName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(R.string.registration);
        mSelectButton = findViewById( R.id.selectDeptButton );
        mSubmitButton = findViewById( R.id.submitButton );
        mName = findViewById( R.id.editTextName );
        mEmail = findViewById( R.id.editTextTextEmail );
        mId = findViewById( R.id.editTextId );
        mDepartmentTextView = findViewById( R.id.textViewDept );
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startProfileActivity();
            }
        });

        mSelectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDepartmentActivity();
            }
        });
    }

    public void startDepartmentActivity()
    {
        Intent intent = new Intent( this, DepartmentActivity.class );
        startActivityForResult( intent, DEPARTMENT_REQUEST_CODE );
    }

    public void startProfileActivity(){
        if( mEmail.getText().toString().isEmpty() || mDepartmentName.isEmpty() || mName.getText().toString().isEmpty() || mId.getText().toString().isEmpty() )
        {
            Toast.makeText( getApplicationContext(), R.string.invalid_text, Toast.LENGTH_SHORT ).show();
        }
        else
        {

            if( !Patterns.EMAIL_ADDRESS.matcher( mEmail.getText()).matches() )
            {
                Toast.makeText( getApplicationContext(), R.string.invalid_text, Toast.LENGTH_SHORT ).show();
            }
            else{
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                Profile profile = new Profile(mName.getText().toString(), mId.getText().toString(), mEmail.getText().toString(), mDepartmentName);
                intent.putExtra(PROFILE_KEY, profile);
                startActivity(intent);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if( requestCode == DEPARTMENT_REQUEST_CODE &&  resultCode == RESULT_OK && data != null )
        {
            mDepartmentName = data.getStringExtra( DEPARTMENT_KEY );
            mDepartmentTextView.setText( mDepartmentName );
        }
    }
}