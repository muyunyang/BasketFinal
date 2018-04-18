package com.example.android.finalfinalcaloriego;

import java.io.Serializable;

/**
 * Created by Cherry on 4/10/18.
 */

public class Profile implements Serializable {
    private String name;
    private int age;
    private String gender;
    private double height;
    private double weight;

    public Profile(String name, int age, String gender, double height, double weight){
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getGender(){
        return gender;
    }

    public double getHeight(){
        return height;
    }

    public double getWeight(){
        return weight;
    }

}
