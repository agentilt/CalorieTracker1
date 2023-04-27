package com.csci3397.myapplication.mainactivity.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

import com.csci3397.myapplication.R;
import com.csci3397.myapplication.mainactivity.model.ShakeDetector;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Revolve extends AppCompatActivity implements ShakeDetector.OnShakeListener {

    private ShakeDetector shakeDetector;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revolve);
        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("https://trinity.campusdish.com/en/locationsandmenus/thecommonsfoodcourt/revolve/");
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomnav);
        // Initialize the SensorManager and accelerometer
        shakeDetector = new ShakeDetector(this);
        shakeDetector.setOnShakeListener(this);



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
                        Intent profileIntent = new Intent(Revolve.this, Profile.class);
                        startActivity(profileIntent);
                        return true;
                    case R.id.history:
                        // Handle history item press
                        // Start the History activity
                        Intent historyIntent = new Intent(Revolve.this, History.class);
                        startActivity(historyIntent);
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        shakeDetector.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        shakeDetector.unregister();
    }

    @Override
    public void onShake(int count) {
        onBackPressed();
    }
}