package com.jenyasubbotina.adoptme.ui.fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jenyasubbotina.adoptme.R;

public class SignUpFragment extends Fragment {

    View v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_sign_up, container, false);
        requireActivity().getWindow().setStatusBarColor(Color.WHITE);
        return v;
    }
}
