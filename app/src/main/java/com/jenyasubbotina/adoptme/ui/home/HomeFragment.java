package com.jenyasubbotina.adoptme.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jenyasubbotina.adoptme.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private View v;
    private RecyclerView petsCards;
    private PetsCardsAdapter petsCardsAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        v = inflater.inflate(R.layout.fragment_home, container, false);
        petsCards = v.findViewById(R.id.pets_recyclerview);
        petsCards.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        petsCardsAdapter = new PetsCardsAdapter(requireContext());
        ArrayList<PetModel> pets = new ArrayList<>();
        pets.add(new PetModel("Нора", "Корги", 1, 2));
        pets.add(new PetModel("Давид", "Кокер-спаниэль", 0, 2));
        pets.add(new PetModel("Бехруз", "Бигль", 0, 2));
        petsCardsAdapter.setPets(pets);
        petsCards.setAdapter(petsCardsAdapter);
//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return v;
    }
}