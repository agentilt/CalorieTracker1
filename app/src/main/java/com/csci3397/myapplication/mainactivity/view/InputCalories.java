package com.csci3397.myapplication.mainactivity.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.csci3397.myapplication.R;
import com.csci3397.myapplication.mainactivity.adapter.FoodAdapter;
import com.csci3397.myapplication.mainactivity.model.foodItems;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class InputCalories extends AppCompatActivity {
    private int caloriesConsumed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_calories);
        List<foodItems> foodList = new ArrayList<>();
        foodList.add(new foodItems("Food 1", 100));
        foodList.add(new foodItems("Food 2", 200));
        foodList.add(new foodItems("Food 3", 300));

        RecyclerView foodRecyclerView = findViewById(R.id.recycler_view);
        foodRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        FoodAdapter foodAdapter = new FoodAdapter(foodList);
        foodRecyclerView.setAdapter(foodAdapter);

        // Setup action bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Get a reference to the BottomNavigationView
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnav);

        // Set the listener for when an item is selected
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.backArrow:
                        // Handle back arrow item press
                        onBackPressed();
                        return true;
                    case R.id.profile:
                        // Handle profile item press
                        // Start the Profile activity
                        Intent profileIntent = new Intent(InputCalories.this, Profile.class);
                        startActivity(profileIntent);
                        return true;
                    case R.id.history:
                        // Handle history item press
                        // Start the History activity
                        Intent historyIntent = new Intent(InputCalories.this, History.class);
                        startActivity(historyIntent);
                        return true;
                }
                return false;
            }
        });

        EditText caloriesEditText = findViewById(R.id.CalorieCount);
        Button confirmButton = findViewById(R.id.confirm);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int calories = Integer.parseInt(caloriesEditText.getText().toString());
                caloriesConsumed += calories;

                Intent intent = new Intent();
                intent.putExtra("caloriesConsumed", caloriesConsumed);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
