package com.example.android.finalfinalcaloriego;

/**
 * Created by Cherry on 4/18/18.
 */

public class Food {
    public String foodName;
    public int foodCalorie;
    public int photoId;
//    public int calorieNumber;
    public boolean checked;

    public Food(String foodName, int foodCalorie, int photoId){
        this.foodName = foodName;
        this.foodCalorie = foodCalorie;
        this.photoId = photoId;
    }
    public String getName(){
        return foodName;
    }

    public int getInfo(){
        return foodCalorie;
    }

    public int getPhotoId(){
        return photoId;
    }

//    public int setCalorieNumber(){
//        calorieNumber = Integer.valueOf(foodCalorie);
//        return calorieNumber;
//    }

}

