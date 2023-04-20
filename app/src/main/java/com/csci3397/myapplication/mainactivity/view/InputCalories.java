package com.csci3397.myapplication.mainactivity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.csci3397.myapplication.R;

public class InputCalories extends AppCompatActivity {
    private int caloriesConsumed = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_calories);

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
}
