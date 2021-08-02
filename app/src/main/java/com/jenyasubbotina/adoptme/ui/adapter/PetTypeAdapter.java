package com.jenyasubbotina.adoptme.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jenyasubbotina.adoptme.R;
import com.jenyasubbotina.adoptme.model.PetTypeModel;

import java.util.ArrayList;
import java.util.List;

public class PetTypeAdapter extends RecyclerView.Adapter<PetTypeAdapter.ViewHolder> {
    List<PetTypeModel> pets = new ArrayList<>();
    Context context;
    int width = Resources.getSystem().getDisplayMetrics().widthPixels;
    int height = Resources.getSystem().getDisplayMetrics().heightPixels;

    public PetTypeAdapter(Context c) {
        this.context = c;
    }

    public void setPets(List<PetTypeModel> pets) {
        this.pets = pets;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PetTypeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_pet_type, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PetTypeModel petTypeModel = pets.get(position);
        holder.petType.setText(petTypeModel.getName());
        ViewGroup.LayoutParams layoutParams = holder.petImage.getLayoutParams();
        layoutParams.width = (int) (width * 0.2);
        layoutParams.height = (int) (height * 0.15);
        holder.petImage.setLayoutParams(layoutParams);
        holder.petImage.requestLayout();

        Glide.with(context)
                .load(petTypeModel.getImgURL())
                .fitCenter()
                .placeholder(R.drawable.ic_cat)
                .into(holder.petImage);
    }

    @Override
    public int getItemCount() {
        return pets != null ? pets.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView petType;
        ImageView petImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            petType = itemView.findViewById(R.id.pet_type_textview);
            petImage = itemView.findViewById(R.id.pet_icon_imageview);
        }
    }
}
