package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class FoodActivity extends AppCompatActivity {


    TextView goalNumber;
    TextView leftNumber;
    TextView consumedNumber;
    private int consumedCalorie;
    private int leftCalorie;
    private int goalCalorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        consumedCalorie = 0;

        goalNumber = (TextView) findViewById(R.id.goalNumber);
        leftNumber = (TextView) findViewById(R.id.leftNumber);
        consumedNumber = (TextView) findViewById(R.id.consumedNumber);
        Intent intent = getIntent();
        goalCalorie = intent.getIntExtra(Keys.SHOW_CALORIE, 0);
        leftCalorie = goalCalorie - consumedCalorie;
        String num = String.valueOf(goalCalorie);
        goalNumber.setText(num + " Kcal");
        leftNumber.setText((num + " Kcal"));
    }


    public void breakfastList(View view) {
        Intent openBf = new Intent(this, BreakfastActivity.class);
        startActivityForResult(openBf, 111);
    }

    public void lunchList(View view) {
        Intent openLunch = new Intent(this, LunchActivity.class);
        startActivityForResult(openLunch, 222);
    }

    public void dinnerList(View view) {
        Intent openDinner = new Intent(this, DinnerActivity.class);
        startActivityForResult(openDinner, 333);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if (resultCode == RESULT_OK && requestCode == 111) {
            if (data.hasExtra("returnKey1")) {
                consumedCalorie = consumedCalorie + data.getIntExtra("returnKey1", 0);
                consumedNumber.setText(String.valueOf(consumedCalorie) + " Kcal");
                leftNumber.setText(String.valueOf(goalCalorie - consumedCalorie) + " Kcal");
            }
        }
        else if (resultCode == RESULT_OK && requestCode == 222) {
            if (data.hasExtra("returnKey2")) {
                consumedCalorie = consumedCalorie + data.getIntExtra("returnKey2", 0);
                consumedNumber.setText(String.valueOf(consumedCalorie) + " Kcal");
                leftNumber.setText(String.valueOf(goalCalorie - consumedCalorie) + " Kcal");
            }
        }
        else if (resultCode == RESULT_OK && requestCode == 333) {
            if (data.hasExtra("returnKey3")) {
                consumedCalorie = consumedCalorie + data.getIntExtra("returnKey3", 0);
                consumedNumber.setText(String.valueOf(consumedCalorie) + " Kcal");
                leftNumber.setText(String.valueOf(goalCalorie - consumedCalorie) + " Kcal");
            }
        }
    }

    public void me(View view){
        Intent meIntent = new Intent(this,MeActivity.class);
        startActivity(meIntent);
    }

    public void news(View view){
        Intent newsIntent = new Intent(this,TabbedActivity.class);
        startActivity(newsIntent);
    }

    public void diary(View view){
        Intent diaryIntent = new Intent(this, DiaryActivity.class);
        startActivity(diaryIntent);
    }


//    @Override
////    protected void onRestart() {
////        super.onRestart();
////        setContentView(R.layout.activity_food);
////        Intent intent2 = getIntent();
////        consumedCalorie += intent2.getIntExtra(Keys.CALORIE_DATA, -1);
//////        lunchCalorie = intent2.getIntExtra(Keys.LUNCH_DATA, -1);
////        String newNum = String.valueOf(consumedCalorie);
////        consumedNumber.setText(String.valueOf(consumedCalorie) + "kCal");
////    }


}

//    Intent aIntent = getIntent();
//    String calorie = aIntent.getStringExtra("calorie");
//        consumedNumber.setText(calorie);
//    int left = Integer.valueOf(goalNumber.getText().toString()) - Integer.valueOf(calorie);
//        leftNumber.setText(left);
//}
