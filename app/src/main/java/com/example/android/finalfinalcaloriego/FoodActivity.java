package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FoodActivity extends AppCompatActivity {


    TextView goalNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        goalNumber = (TextView) findViewById(R.id.goalNumber);
        Intent intent = getIntent();
        int goalCalorie = intent.getIntExtra(Keys.SHOW_CALORIE,-1);
        String num = String.valueOf(goalCalorie);
        goalNumber.setText(num + " Kcal");
    }

    public void breakfastList(View view){
        Intent openBf = new Intent(this,BreakfastActivity.class);
        startActivity(openBf);
    }
}
