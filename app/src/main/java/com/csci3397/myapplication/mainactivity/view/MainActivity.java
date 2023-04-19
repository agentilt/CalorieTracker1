package com.csci3397.myapplication.mainactivity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.csci3397.myapplication.R;
import com.csci3397.myapplication.mainactivity.model.User;

public class MainActivity extends AppCompatActivity {
    User user = new User();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button todaybtn = findViewById(R.id.todayBtn);
            Button recs = findViewById(R.id.recsBtn);
            Button input = findViewById(R.id.inputCalsBtn);
            ProgressBar progressBar = findViewById(R.id.progressBar);
            progressBar.setMax(user.getCalorieGoal());
            progressBar.setProgress(user.getCaloriesConsumed());
            EditText calorieTracker = findViewById(R.id.calorieTracker);
            calorieTracker.setText(user.getCaloriesConsumed() + "/" + user.getCalorieGoal() + " calories");



            input.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){


                    //Intent intent = new Intent(view.getContext(), InputCalories.class);
                    //startActivity(intent);

                }
            });

        }
    }
