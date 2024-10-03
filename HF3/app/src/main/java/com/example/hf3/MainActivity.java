package com.example.hf3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> products= new ArrayList<>();

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

        EditText code= findViewById(R.id.edtCode);
        EditText name= findViewById(R.id.edtName);
        EditText price= findViewById(R.id.edtPrice);
        Button add= findViewById(R.id.btnAdd);
        Button cancel= findViewById(R.id.btnCancel);
        Button show= findViewById(R.id.btnShow);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kod=code.getText().toString();
                String nev=name.getText().toString();
                String ar=price.getText().toString();
                if (kod)
                products.add(new Product(kod,nev,ar));
                Toast.makeText(MainActivity.this, "Sikeres bevitel", Toast.LENGTH_SHORT).show();


            }
        });

    }
}