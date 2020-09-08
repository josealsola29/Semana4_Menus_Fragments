package com.example.semana4;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.semana4.adapter.PetAdapter;
import com.example.semana4.model.Pet;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    private ArrayList<Pet> pets;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);


        RecyclerView recyclerView = v.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        initDummyData();
        PetAdapter petAdapter = new PetAdapter(pets);
        recyclerView.setAdapter(petAdapter);
        return v;
    }

    private void initDummyData() {
        pets = new ArrayList<>();
        pets.add(new Pet("Schrödinger", 0, R.drawable.icons8_black_cat));
        pets.add(new Pet("Shaggy", 0, R.drawable.icons8_dog));
        pets.add(new Pet("Inu", 0, R.drawable.icons8_dog_));
        pets.add(new Pet("Flash", 0, R.drawable.icons8_turtle));
    }
}
