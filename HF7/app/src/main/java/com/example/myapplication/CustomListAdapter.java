package com.example.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Animal;

import java.util.List;

public class CustomListAdapter extends RecyclerView.Adapter<CustomListAdapter.VH> {
    private Activity context;
    private List<Animal> animals;

    public CustomListAdapter(Activity context, List<Animal> animals) {
        this.context = context;
        this.animals = animals;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.listview_row, parent, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        Animal contact = animals.get(position);
        holder.name.setText(contact.getName());
        holder.info.setText(contact.getInfo());
        holder.image.setImageResource(contact.getImage());


    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView info;

        public VH(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            info = itemView.findViewById(R.id.info);
            image = itemView.findViewById(R.id.image);

        }
    }
}
