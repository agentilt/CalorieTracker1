package com.csci3397.myapplication.mainactivity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.csci3397.myapplication.R;
import com.csci3397.myapplication.mainactivity.model.Food;
import com.csci3397.myapplication.mainactivity.model.SQLiteManager;

public class FoodActivity extends AppCompatActivity {
    private ListView FoodListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        initWidgets();
        setFoodAdapter();
        loadFromDBToMemory();
        setOnClickListener();

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

    private void setOnClickListener()
    {
        FoodListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Food selectedFood = (Food) FoodListView.getItemAtPosition(position);
                Intent editFoodIntent = new Intent(getApplicationContext(), FoodDetailActivity.class);
                editFoodIntent.putExtra(Food.Food_EDIT_EXTRA, selectedFood.getId());
                startActivity(editFoodIntent);
            }
        });
    }
    private void loadFromDBToMemory()
    {
        SQLiteManager sqLiteManager = SQLiteManager.instanceOfDatabase(this);
        sqLiteManager.populateFoodListArray();
    }

    public void newFood(View view)
    {
        Intent newFoodIntent = new Intent(this, FoodDetailActivity.class);
        startActivity(newFoodIntent);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        setFoodAdapter();
    }

}
