package com.jenyasubbotina.adoptme.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.jenyasubbotina.adoptme.R;

public class AuthStartFragment extends Fragment {

    View v;
    NavController navController;
    Button signInButton, signUpButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_auth_start, container, false);
        navController = NavHostFragment.findNavController(AuthStartFragment.this);
        signInButton = v.findViewById(R.id.button_login);
        signUpButton = v.findViewById(R.id.button_register);

        signInButton.setOnClickListener(v -> {
            signInButton.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bubble));
            navController.navigate(R.id.signUpFragment);
        });

        signUpButton.setOnClickListener(v -> {
            signUpButton.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bubble));
            navController.navigate(R.id.signUpFragment);
        });

        return v;
    }
}