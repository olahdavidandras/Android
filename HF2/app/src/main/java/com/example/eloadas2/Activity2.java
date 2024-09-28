package com.example.eloadas2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button gomb = findViewById(R.id.ButtonAct2);

        gomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity2.this, Activity3.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("Statusz: ", "Activity2 - onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d("Statusz: ", "Activity2 - onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz: ", "Activity2 - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz: ", "Activity2 - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz: ", "Activity2 - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz: ", "Activity2 - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz: ", "Activity2 - onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz: ", "Activity2 - onDestroy");
    }
}