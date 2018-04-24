package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FoodActivity extends AppCompatActivity {


    TextView goalNumber;
    TextView leftNumber;
    TextView consumedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        goalNumber = (TextView) findViewById(R.id.goalNumber);
        leftNumber = (TextView) findViewById(R.id.leftNumber);
        consumedNumber = (TextView) findViewById(R.id.consumedNumber);
        Intent intent = getIntent();
        int goalCalorie = intent.getIntExtra(Keys.SHOW_CALORIE, -1);
        String num = String.valueOf(goalCalorie);
        goalNumber.setText(num + " Kcal");
        leftNumber.setText((num + " Kcal"));
        Intent intent2 = getIntent();
        goalCalorie = intent2.getIntExtra(Keys.CALORIE_DATA,-1);
        String newNum = String.valueOf(goalCalorie);
        consumedNumber.setText(newNum + "kCal");
    }

    public void breakfastList(View view) {
        Intent openBf = new Intent(this, BreakfastActivity.class);
        startActivity(openBf);
    }

    public void lunchList(View view) {
        Intent openLunch = new Intent(this, LunchActivity.class);
        startActivity(openLunch);
    }

    public void dinnerList(View view) {
        Intent openDinner = new Intent(this, LunchActivity.class);
        startActivity(openDinner);
    }
}

//    Intent aIntent = getIntent();
//    String calorie = aIntent.getStringExtra("calorie");
//        consumedNumber.setText(calorie);
//    int left = Integer.valueOf(goalNumber.getText().toString()) - Integer.valueOf(calorie);
//        leftNumber.setText(left);
//}
