package com.example.myapplication;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private ArrayList<String> listItems;
    private ArrayAdapter<String> myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = findViewById(R.id.simpleListView);
        listItems = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.Napok)));
        myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        list.setAdapter(myAdapter);

        registerForContextMenu(list);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int pos = info.position;
        int id = item.getItemId();
        int color;
        if (id == R.id.piros) {
            color = 0xFFFF0000;
        } else if (id == R.id.zold) {
            color = 0xFF00FF00;
        } else if (id == R.id.sarga) {
            color = 0xFFFFFF00;
        } else {
            return super.onContextItemSelected(item);
        }
        View listItem = list.getChildAt(pos - list.getFirstVisiblePosition());
        if (listItem != null) {
            TextView textView = (TextView) listItem.findViewById(android.R.id.text1);
            textView.setTextColor(color);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.rendez) {
            Collections.sort(listItems);
            myAdapter.notifyDataSetChanged();
        } else if (id == R.id.torol) {
            listItems.clear();
            myAdapter.notifyDataSetChanged();
        }
        return true;
    }
}