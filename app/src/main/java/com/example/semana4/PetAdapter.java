package com.example.semana4;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Random;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {
    ArrayList<Pet> pets;

    public PetAdapter(ArrayList<Pet> pets) {
        this.pets = pets;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pets,
                parent, false);
        return new PetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PetViewHolder holder, final int position) {
        Pet pet = pets.get(position);
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.ivPet.setBackgroundColor(color);
        holder.ivPet.setImageResource(pet.getPetImage());
        holder.tvPetName.setText(pet.getPetName());
        holder.tvPetPoints.setText(String.valueOf(pet.getPetPoints()));
        holder.ibPetLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cont = pets.get(position).getPetPoints();
                cont = cont + 1;
                pets.get(position).setPetPoints(cont);
                holder.tvPetPoints.setText(String.valueOf(cont));
            }
        });
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPet;
        private TextView tvPetName;
        private TextView tvPetPoints;
        private ImageButton ibPetLike;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPet = itemView.findViewById(R.id.ivPet);
            tvPetName = itemView.findViewById(R.id.tvPetName);
            tvPetPoints = itemView.findViewById(R.id.tvPetPoints);
            ibPetLike = itemView.findViewById(R.id.ivPetLike);
        }
    }
}