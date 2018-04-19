package com.example.android.finalfinalcaloriego;

import java.io.Serializable;

/**
 * Created by Cherry on 4/10/18.
 */

public class Profile implements Serializable {
    public String name;
    public int age;
    public String gender;
    public double height;
    public double weight;
    public double bmi;
    public int calorie;


    public Profile(String name, int age, String gender, double height, double weight) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public double getBmi() {
        bmi = weight / (height * height / 10000);
        return bmi;
    }

    public int getCalorie() {
        if (bmi > 23) {
            calorie = 1800;
        } else if (bmi < 18) {
            calorie = 2200;
        } else {
            calorie = 2000;
        }
        return calorie;
    }
}

