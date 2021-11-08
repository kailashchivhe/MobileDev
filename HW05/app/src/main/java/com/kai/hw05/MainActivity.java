package com.kai.hw05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kai.hw05.firebase.FirebaseHelper;

/*
* Name: Kailash Chivhe & Ankit Vaity
* Assignment: HW05
* MainActivity
* */
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseHelper.initFirebase();
    }
}