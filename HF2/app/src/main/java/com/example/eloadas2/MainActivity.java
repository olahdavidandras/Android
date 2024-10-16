package com.example.eloadas2;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView text1;
    EditText text2;
    CheckBox check;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d("Statusz: ", "MainActivity - onCreate");

        Button gomb = findViewById(R.id.ButtonMain);

        gomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                startActivity(intent);
            }
        });

        text1 = findViewById(R.id.textView3);
        text2 = findViewById(R.id.BemenetiSzoveg);
        check = findViewById(R.id.checkBox);

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.append("\n" + text1.getText().toString());
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("Statusz: ", "MainActivity - onSaveInstanceState");
        super.onSaveInstanceState(outState);

        //kimentes a Bundle-ben
        outState.putString("txt", text1.getText().toString());
        outState.putString("txt2", text2.getText().toString());
        outState.putBoolean("chc", check.isChecked());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d("Statusz: ", "MainActivity - onRestoreInstanceState");
        super.onRestoreInstanceState(savedInstanceState);
        text1.setText(savedInstanceState.getString("txt"));
        text2.setText(savedInstanceState.getString("txt2"));
        check.setChecked(savedInstanceState.getBoolean("chc"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Statusz: ", "MainActivity - onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Statusz: ", "MainActivity - onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Statusz: ", "MainActivity - onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("Statusz: ", "MainActivity - onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("Statusz: ", "MainActivity - onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Statusz: ", "MainActivity - onDestroy");
    }

}