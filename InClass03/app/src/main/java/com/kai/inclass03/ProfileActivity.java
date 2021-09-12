package com.kai.inclass03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    String mName;
    String mEmail;
    String mId;
    String mDepartmentName;

    TextView mNameTextView;
    TextView mEmailTextView;
    TextView mIdTextView;
    TextView mDepartmentNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle(R.string.profile);

        mEmailTextView = findViewById( R.id.textViewProfileEmail );
        mNameTextView = findViewById( R.id.textViewProfileName );
        mIdTextView = findViewById( R.id.textViewProfileId );
        mDepartmentNameTextView = findViewById( R.id.textViewProfileDept );

        if( getIntent() != null )
        {
            Profile profile = (Profile) getIntent().getSerializableExtra( MainActivity.PROFILE_KEY );

            mEmailTextView.setText( profile.mEmail );
            mNameTextView.setText( profile.mName );
            mIdTextView.setText( profile.mId );
            mDepartmentNameTextView.setText( profile.mDept );
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}