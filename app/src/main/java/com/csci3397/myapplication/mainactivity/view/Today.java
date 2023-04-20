package com.csci3397.myapplication.mainactivity.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;

import com.csci3397.myapplication.R;

public class Today extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("https://trinity.campusdish.com/en/locationsandmenus/mabeedininghall/");
    }

}