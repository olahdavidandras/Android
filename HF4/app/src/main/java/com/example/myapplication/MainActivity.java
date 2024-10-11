package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String[] nameArray = {"EUR",
            "USD",
            "GBP",
            "AUD",
            "CAD",
            "CHF",
            "DKK",
            "HUF"};
    String[] infoArray = {"Euro",
            "Dolar american",
            "Lira sterlina",
            "Dolar australian",
            "Dolar canadian",
            "Franc elvetian",
            "Coroana daneza",
            "Forint maghiar"};
    String[] cumparaArray = {"4,4100 RON",
            "3,9750 RON",
            "6,1250 RON",
            "2,9600 RON",
            "3,0950 RON",
            "4,2300 RON",
            "0,5850 RON",
            "0,0136 RON"};
    String[] vindeArray = {"4,5500 RON",
            "4,1450 RON",
            "6,3550 RON",
            "3,0600 RON",
            "3,2650 RON",
            "4,3300 RON",
            "0,6150 RON",
            "0,0146 RON"};
    Integer[] imageArray = {
            R.drawable.eu,
            R.drawable.usa,
            R.drawable.gb,
            R.drawable.australia,
            R.drawable.canada,
            R.drawable.switzerland,
            R.drawable.denmark,
            R.drawable.hungary};

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

        ListView list = findViewById(R.id.customListView);
        CustomListAdapter adapter = new CustomListAdapter(this, nameArray, infoArray, cumparaArray, vindeArray, imageArray);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String name = nameArray[position];
                String price = cumparaArray[position];
                Toast.makeText(MainActivity.this, name + " " + price, Toast.LENGTH_SHORT).show();
            }
        });
    }
}