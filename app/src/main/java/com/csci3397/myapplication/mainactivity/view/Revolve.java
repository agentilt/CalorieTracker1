package com.csci3397.myapplication.mainactivity.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.csci3397.myapplication.R;

public class Revolve extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revolve);
        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("https://trinity.campusdish.com/en/locationsandmenus/thecommonsfoodcourt/revolve/");
    }
}