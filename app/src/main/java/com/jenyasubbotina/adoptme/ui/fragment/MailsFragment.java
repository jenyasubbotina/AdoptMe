package com.jenyasubbotina.adoptme.ui.fragment;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jenyasubbotina.adoptme.R;
import com.jenyasubbotina.adoptme.viewmodel.MailsViewModel;

public class MailsFragment extends Fragment {

    private MailsViewModel mViewModel;

    public static MailsFragment newInstance() {
        return new MailsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mails, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MailsViewModel.class);
        // TODO: Use the ViewModel
    }

}