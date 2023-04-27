package com.csci3397.myapplication.mainactivity.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;

import com.csci3397.myapplication.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Recommendations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);
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
                        Intent profileIntent = new Intent(Recommendations.this, Profile.class);
                        startActivity(profileIntent);
                        return true;
                    case R.id.history:
                        // Handle history item press
                        // Start the History activity
                        Intent historyIntent = new Intent(Recommendations.this, History.class);
                        startActivity(historyIntent);
                        return true;
                }
                return false;
            }
        });
    }
}