package com.example.android.finalfinalcaloriego;

/**
 * Created by yangmuyun on 4/22/18.
 */

public class User {
    private String useremail;
    private String password;
    private String nameText;
    private String ageText;

    private String heightText;
    private String weightText;
    private String id;



    public User() {
    }

    public User(String useremail, String password, String nameText, String ageText, String heightText, String weightText) {
        this.useremail = useremail;
        this.password = password;
        this.nameText = nameText;
        this.ageText = ageText;

        this.heightText = heightText;
        this.weightText = weightText;

    }

    public void setId(String id) {
        this.id = id;
    }



    public String getAgeText() {
        return ageText;
    }


    public String getHeightText() {
        return heightText;
    }

    public String getWeightText() {
        return weightText;
    }

}
