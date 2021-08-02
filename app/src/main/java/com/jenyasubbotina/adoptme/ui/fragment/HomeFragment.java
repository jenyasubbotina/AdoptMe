package com.jenyasubbotina.adoptme.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jenyasubbotina.adoptme.R;
import com.jenyasubbotina.adoptme.network.RetrofitClient;
import com.jenyasubbotina.adoptme.ui.adapter.PetTypeAdapter;
import com.jenyasubbotina.adoptme.ui.adapter.PetsCardsAdapter;
import com.jenyasubbotina.adoptme.viewmodel.PetTypeViewModel;
import com.jenyasubbotina.adoptme.viewmodel_factory.PetTypeViewModelFactory;

public class HomeFragment extends Fragment {

    private View v;
    private RecyclerView petsCardsRecyclerView;
    private PetsCardsAdapter petsCardsAdapter;

    private RecyclerView petTypesRecyclerView;
    private PetTypeAdapter petTypeAdapter;

    private PetTypeViewModel petTypeViewModel;
    RetrofitClient retrofitClient;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final PetTypeViewModelFactory petTypeViewModelFactory = new PetTypeViewModelFactory(requireContext());
        petTypeViewModel = new ViewModelProvider(getViewModelStore(), petTypeViewModelFactory).get(PetTypeViewModel.class);
        petTypeViewModel.getAvailablePetTypes();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);

        petsCardsRecyclerView = v.findViewById(R.id.pets_recyclerview);
        petTypesRecyclerView = v.findViewById(R.id.types_recyclerview);

        petsCardsRecyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        petsCardsAdapter = new PetsCardsAdapter(requireContext());
        petsCardsRecyclerView.setAdapter(petsCardsAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        petTypesRecyclerView.setLayoutManager(linearLayoutManager);
        petTypeAdapter = new PetTypeAdapter(requireContext());
        petTypesRecyclerView.setAdapter(petTypeAdapter);

        petTypeViewModel.getPetTypesList().observe(getViewLifecycleOwner(), petTypeList -> {
            petTypeAdapter.setPets(petTypeList);
            System.out.println(petTypeList.size() + " size");
        });

        return v;
    }
}
