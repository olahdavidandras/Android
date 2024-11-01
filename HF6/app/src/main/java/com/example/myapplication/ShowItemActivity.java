package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.widget.TextView;

public class ShowItemActivity extends AppCompatActivity {

    // In ShowItemActivity.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_item);

        TextView detailsTextView = findViewById(R.id.detailsTextView);
        String itemDetails = getIntent().getStringExtra("itemDetails");
        if (itemDetails != null) {
            detailsTextView.setText(itemDetails);
        }
    }


}