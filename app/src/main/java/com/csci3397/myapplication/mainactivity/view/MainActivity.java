package com.csci3397.myapplication.mainactivity.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.csci3397.myapplication.R;
import com.csci3397.myapplication.mainactivity.model.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    User user = new User();
    private int caloriesConsumed = 0;
    private ProgressBar progressBar;
    private TextView calorieTracker;
    private static final int INPUT_CALORIES_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button todaybtn = findViewById(R.id.todayBtn);
        Button recs = findViewById(R.id.recsBtn);
        Button input = findViewById(R.id.inputCalsBtn);
        Button recomendation = findViewById(R.id.reccomendationsBtn);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(user.getCalorieGoal());
        progressBar.setProgress(user.getCaloriesConsumed());
        calorieTracker = findViewById(R.id.calorieTracker);
        calorieTracker.setText(user.getCaloriesConsumed() + "/" + user.getCalorieGoal() + " calories");


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnav);

        // Set the listener for when an item is selected
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.backArrow:
                        // Handle back arrow item press

                        return true;
                    case R.id.profile:
                        // Handle profile item press
                        // Start the Profile activity
                        Intent profileIntent = new Intent(MainActivity.this, Profile.class);
                        startActivity(profileIntent);
                        return true;
                    case R.id.history:
                        // Handle history item press
                        // Start the History activity
                        Intent historyIntent = new Intent(MainActivity.this, History.class);
                        startActivity(historyIntent);
                        return true;
                }
                return false;
            }
        });
        input.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, InputCalories.class);
                startActivityForResult(intent, INPUT_CALORIES_REQUEST);
            }
        });
        todaybtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Today.class);
                startActivity(intent);
            }
        });
        recs.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Revolve.class);
                startActivity(intent);
            }
        });
        recomendation.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Recommendations.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Check if the request code matches the input calories request code
        if (requestCode == INPUT_CALORIES_REQUEST) {
            // Check if the result code is RESULT_OK
            if (resultCode == RESULT_OK) {
                // Retrieve the updated caloriesConsumed value from the InputCalories activity
                int newCaloriesConsumed = data.getIntExtra("caloriesConsumed", 0);

                // Update the calorie tracker and progress bar with the new value
                caloriesConsumed += newCaloriesConsumed;
                calorieTracker.setText(caloriesConsumed + "/" + user.getCalorieGoal() + " calories");
                progressBar.setProgress(caloriesConsumed);
            }
        }
    }


}





