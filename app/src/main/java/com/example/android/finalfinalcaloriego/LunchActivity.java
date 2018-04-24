package com.example.android.finalfinalcaloriego;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class LunchActivity extends AppCompatActivity {
    private ArrayList<Food> lunch;
    private LunchAdapter lunchAdapter;
    private EditText foodText;
    private EditText calText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);
        initialData();

        foodText = findViewById(R.id.enter_food);
        setContentView(R.layout.activity_lunch);
        calText = findViewById(R.id.enter_calorie);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.recycler_view2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        lunchAdapter = new LunchAdapter(lunch, this);
        recyclerView2.setAdapter(lunchAdapter);
    }

    private void initialData() {
        lunch = new ArrayList<>();
        lunch.add(new Food("Beef（200g)", "212", R.drawable.beef));
        lunch.add(new Food("Pork（200g)", "286", R.drawable.pork));
        lunch.add(new Food("Chicken（200g)", "266", R.drawable.chicken));
        lunch.add(new Food("Spagetti(200g)", "700", R.drawable.spagetti));
        lunch.add(new Food("A bowl of rice", "232", R.drawable.rice));
        lunch.add(new Food("Spinach(200g)", "28", R.drawable.spinach));
        lunch.add(new Food("Cabbage(200g)", "31", R.drawable.cabbage));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private Food foodInfo() {
        String name = foodText.getText().toString();
        String calorie = calText.getText().toString();
        return new Food(name,calorie,R.drawable.defaultpic);}


    public void addItem(View view) {
        lunch.add(foodInfo());
        lunchAdapter.notifyDataSetChanged();
    }
}


