package com.example.android.finalfinalcaloriego;

/**
 * Created by Cherry on 4/18/18.
 */

public class Breakfast {
    public String foodName;
    public String info;
    public int photoId;

    public Breakfast(String foodName, String info, int photoId){
        this.foodName = foodName;
        this.info = info;
        this.photoId = photoId;
    }
    public String getName(){
        return foodName;
    }

    public String getInfo(){
        return info;
    }

    public int getPhotoId(){
        return photoId;
    }
}

