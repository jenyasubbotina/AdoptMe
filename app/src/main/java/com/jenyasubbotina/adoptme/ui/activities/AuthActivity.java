package com.jenyasubbotina.adoptme.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.jenyasubbotina.adoptme.R;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        getWindow().setStatusBarColor(getColor(R.color.dark_purple));
    }
}