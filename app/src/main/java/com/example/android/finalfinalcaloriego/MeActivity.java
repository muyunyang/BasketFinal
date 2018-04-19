package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MeActivity extends AppCompatActivity {
    private double bmi;
    private String calorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        TextView nameContent = findViewById(R.id.name_enter);
        TextView ageContent = findViewById(R.id.age_enter);
        TextView genderContent = findViewById(R.id.gender_enter);
        TextView heightContent = findViewById(R.id.height_enter);
        TextView weightContent = findViewById(R.id.weight_enter);
        TextView calorieContent = findViewById(R.id.calorie_enter);
        TextView bmiContent = findViewById(R.id.bmi_enter);
        Intent myIntent = getIntent();
        Profile resultProfile = (Profile)myIntent.getSerializableExtra(Keys.PERSON);

        String showName = resultProfile.getName();
        int showAge = resultProfile.getAge();
        String showGender = resultProfile.getGender();
        double showHeight = resultProfile.getHeight();
        double showWeight = resultProfile.getWeight();
        nameContent.setText("Name: " + showName);
        ageContent.setText("Age: " + showAge);
        genderContent.setText("Gender: " + showGender);
        heightContent.setText("Height(cm): " + showHeight);
        weightContent.setText("Weight(kg): " + showWeight);
        bmi = showWeight/(showHeight*showHeight/10000);
        bmiContent.setText("BMI: " + bmi);
        if (bmi > 23){
            calorie = "1700-1900";
        }
        else if(bmi < 18){
            calorie = "2100-2300";
        }
        else {
            calorie = "1900-2100";
        }
        calorieContent.setText("Suggested calorie per day: " + calorie + "Kcal");
    }
}