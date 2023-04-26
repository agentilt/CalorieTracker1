package com.csci3397.myapplication.mainactivity.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

import com.csci3397.myapplication.R;

import java.util.Random;

public class History extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        resultTextView = findViewById(R.id.result);

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String date = String.format("%d/%d/%d", month+1, dayOfMonth, year);
                String food = getRandomFoodName();
                int calories = getRandomCalories();

                String resultText = "On " + date + ", you ate " + food + " which was " + calories + " calories.";
                resultTextView.setText(resultText);
            }
        });
    }

    private String getRandomFoodName() {
        String[] foods = getResources().getStringArray(R.array.food_list);
        int index = new Random().nextInt(foods.length);
        return foods[index];
    }

    private int getRandomCalories() {
        return new Random().nextInt(801) + 200;
    }
}
