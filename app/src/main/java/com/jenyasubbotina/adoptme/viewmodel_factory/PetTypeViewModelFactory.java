package com.jenyasubbotina.adoptme.viewmodel_factory;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.jenyasubbotina.adoptme.viewmodel.PetTypeViewModel;

public class PetTypeViewModelFactory implements ViewModelProvider.Factory {
    private final Context context;

    public PetTypeViewModelFactory(final Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PetTypeViewModel.class)) {
            return (T) new PetTypeViewModel(context);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
