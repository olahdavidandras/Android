package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomListAdapter extends ArrayAdapter {
    private Activity context;
    private String[] nameArray;
    private String[] infoArray;
    private String[] cumparaArray;
    private String[] vindeArray;
    private Integer[] imageArray;

    public CustomListAdapter(@NonNull Activity context, String[] nameArray, String[] infoArray, String[] cumparaArray, String[] vindeArray, Integer[] imageArray) {
        super(context, R.layout.layoutview_row, nameArray);
        this.context = context;
        this.nameArray = nameArray;
        this.infoArray = infoArray;
        this.cumparaArray = cumparaArray;
        this.vindeArray = vindeArray;
        this.imageArray = imageArray;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.layoutview_row, null, true);

        TextView name = rowView.findViewById(R.id.txtName);
        TextView info = rowView.findViewById(R.id.txtInfo);
        TextView cumpara = rowView.findViewById(R.id.txtCumpara);
        TextView vinde = rowView.findViewById(R.id.txtVinde);
        ImageView image = rowView.findViewById(R.id.imageView);

        name.setText(nameArray[position]);
        info.setText(infoArray[position]);
        cumpara.setText(cumparaArray[position]);
        vinde.setText(vindeArray[position]);
        image.setImageResource(imageArray[position]);

        return rowView;
    }
}
