package com.example.semana4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Pet> pets;
    private PetAdapter petAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        initDummyData();
        petAdapter = new PetAdapter(pets);
        recyclerView.setAdapter(petAdapter);
    }
    private void initDummyData() {
        pets = new ArrayList<>();
        pets.add(new Pet("Schrödinger", 0, R.drawable.icons8_black_cat));
        pets.add(new Pet("Shaggy", 0, R.drawable.icons8_dog));
        pets.add(new Pet("Inu", 0, R.drawable.icons8_dog_));
        pets.add(new Pet("Flash", 0, R.drawable.icons8_turtle));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pets, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_favoritePets) {

            Intent intent = new Intent(this, TopFavoritesPets.class);
//            intent.putStringArrayListExtra("favs",)
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}