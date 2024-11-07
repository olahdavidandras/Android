package com.example.myapplication;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    private String info;
    private int image;

    public Animal(String name, String info, int image) {
        this.name = name;
        this.info = info;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public static List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Animal("Octopus", "8 tentacled monster", R.drawable.cat));
        animals.add(new Animal("Pig", "Legcukibb allatka", R.drawable.disznyo));
        animals.add(new Animal("Sheep", "Great for jumpers", R.drawable.dog));
        animals.add(new Animal("Rabbit", "Nice in a stew", R.drawable.giraffe));
        animals.add(new Animal("Snake", "Great for shoes", R.drawable.horse));
        animals.add(new Animal("Spider", "Scary", R.drawable.lion));
        animals.add(new Animal("Spider", "Scary", R.drawable.octopus));
        animals.add(new Animal("Spider", "Scary", R.drawable.octopus3));
        animals.add(new Animal("Spider", "Scary", R.drawable.rabbit));

        return animals;
    }
}
