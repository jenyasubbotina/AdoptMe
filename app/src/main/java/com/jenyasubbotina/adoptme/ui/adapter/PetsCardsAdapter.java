package com.jenyasubbotina.adoptme.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jenyasubbotina.adoptme.R;
import com.jenyasubbotina.adoptme.model.PetModel;

import java.util.ArrayList;

public class PetsCardsAdapter extends RecyclerView.Adapter<PetsCardsAdapter.ViewHolder> {

    ArrayList<PetModel> pets = new ArrayList<>();
    Context context;

    public PetsCardsAdapter(Context c) {
        this.context = c;
    }

    public void setPets(ArrayList<PetModel> pets) {
        this.pets = pets;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_pet_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PetModel pet = pets.get(position);
        holder.petName.setText(pet.getName());
        holder.petBreed.setText(pet.getBreed());
        if (pet.getSex() == 1) {
            holder.petSex.setImageResource(R.drawable.ic_female);
        } else {
            holder.petSex.setImageResource(R.drawable.ic_male);
        }
    }

    @Override
    public int getItemCount() {
        return pets != null ? pets.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView petImage, petSex;
        TextView petName, petAge, petBreed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            petImage = itemView.findViewById(R.id.pet_photo_imageview);
            petSex = itemView.findViewById(R.id.pet_sex_imageview);

            petName = itemView.findViewById(R.id.pet_name_textview);
            petAge = itemView.findViewById(R.id.pet_age_textview);
            petBreed = itemView.findViewById(R.id.pet_breed_textview);
        }
    }
}
