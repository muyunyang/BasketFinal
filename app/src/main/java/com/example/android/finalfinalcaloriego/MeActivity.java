package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MeActivity extends AppCompatActivity {

    TextView calorieContent;
    Profile resultProfile;
    int showCalorie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        TextView nameContent = findViewById(R.id.name_enter);
        TextView ageContent = findViewById(R.id.age_enter);
        TextView genderContent = findViewById(R.id.gender_enter);
        TextView heightContent = findViewById(R.id.height_enter);
        TextView weightContent = findViewById(R.id.weight_enter);
        calorieContent = findViewById(R.id.calorie_enter);
        TextView bmiContent = findViewById(R.id.bmi_enter);
        Intent myIntent = getIntent();
        resultProfile = (Profile)myIntent.getSerializableExtra(Keys.PERSON);

        String showName = resultProfile.getName();
        int showAge = resultProfile.getAge();
        String showGender = resultProfile.getGender();
        double showHeight = resultProfile.getHeight();
        double showWeight = resultProfile.getWeight();
        double showBmi = resultProfile.getBmi();
        showCalorie = resultProfile.getCalorie();
        nameContent.setText("Name: " + showName);
        ageContent.setText("Age: " + showAge);
        genderContent.setText("Gender: " + showGender);
        heightContent.setText("Height(cm): " + showHeight);
        weightContent.setText("Weight(kg): " + showWeight);
        bmiContent.setText("BMI: " + showBmi);
        calorieContent.setText("Suggested calorie per day: " + showCalorie + "Kcal");
    }

    public void food(View view){
        Intent foodIntent = new Intent(this,FoodActivity.class);
        foodIntent.putExtra(Keys.SHOW_CALORIE, showCalorie);
        startActivity(foodIntent);
    }
}