package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

        EditText szam1 = findViewById(R.id.szam1);
        EditText szam2 = findViewById(R.id.szam2);
        TextView eredmeny = findViewById(R.id.eredmeny);
        Button osszeadas = findViewById(R.id.osszeadas);
        Button kivonas = findViewById(R.id.kivonas);
        Button szorzas = findViewById(R.id.szorzas);
        Button osztas = findViewById(R.id.osztas);

        osszeadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float szam11 = Float.parseFloat(szam1.getText().toString());
                float szam12 = Float.parseFloat(szam2.getText().toString());
                float ossz = szam11 + szam12;
                eredmeny.setText(String.valueOf(ossz));
            }
        });
        kivonas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float szam11 = Float.parseFloat(szam1.getText().toString());
                float szam12 = Float.parseFloat(szam2.getText().toString());
                float ossz = szam11 - szam12;
                eredmeny.setText(String.valueOf(ossz));
            }
        });
        szorzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float szam11 = Float.parseFloat(szam1.getText().toString());
                float szam12 = Float.parseFloat(szam2.getText().toString());
                float ossz = szam11 * szam12;
                eredmeny.setText(String.valueOf(ossz));
            }
        });
        szorzas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float szam11 = Float.parseFloat(szam1.getText().toString());
                float szam12 = Float.parseFloat(szam2.getText().toString());
                if (szam12 != 0) {
                    float ossz = szam11 / szam12;
                    eredmeny.setText(String.valueOf(ossz));
                } else {
                    eredmeny.setText(String.valueOf(0));
                }

            }
        });


    }
}