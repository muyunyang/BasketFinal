package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class DinnerActivity extends AppCompatActivity {
    private ArrayList<Food> dinner;
    private DinnerAdapter dinnerAdapter;
    private EditText dinnerCalorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);
        initialData();

        dinnerCalorie = findViewById(R.id.enter_calorie);
        RecyclerView recyclerView3 = findViewById(R.id.recycler_view3);
        recyclerView3.setHasFixedSize(true);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));
        dinnerAdapter = new DinnerAdapter(dinner, this);
        recyclerView3.setAdapter(dinnerAdapter);
    }

    private void initialData() {
        dinner = new ArrayList<>();
        dinner.add(new Food("Beef（200g)", 212, R.drawable.beef));
        dinner.add(new Food("Pork（200g)", 286, R.drawable.pork));
        dinner.add(new Food("Chicken（200g)", 266, R.drawable.chicken));
        dinner.add(new Food("Spagetti(200g)", 700, R.drawable.spagetti));
        dinner.add(new Food("A bowl of rice", 32, R.drawable.rice));
        dinner.add(new Food("Spinach(200g)",28, R.drawable.spinach));
        dinner.add(new Food("Cabbage(200g)",31, R.drawable.cabbage));
    }


    public void finishDinner(View view) {
        Intent backIntent = new Intent(this, FoodActivity.class);
        int dnCalorie = Integer.valueOf(dinnerCalorie.getText().toString());
        backIntent.putExtra("returnKey3", dnCalorie);
        setResult(RESULT_OK, backIntent);
        super.finish();
    }
}

