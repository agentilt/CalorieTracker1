package com.csci3397.myapplication.mainactivity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.csci3397.myapplication.R;
import com.csci3397.myapplication.mainactivity.model.Food;

public class FoodActivity extends AppCompatActivity {
    private ListView FoodListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        initWidgets();
        setFoodAdapter();

    }

    private void initWidgets()
    {
        FoodListView = findViewById(R.id.FoodListView);
    }

    private void setFoodAdapter()
    {
        FoodAdapter noteAdapter = new FoodAdapter(getApplicationContext(), Food.FoodArrayList);
        FoodListView.setAdapter(noteAdapter);
    }

    public void newFood(View view)
    {
        Intent newFoodIntent = new Intent(this, FoodDetailActivity.class);
        startActivity(newFoodIntent);
    }

}
