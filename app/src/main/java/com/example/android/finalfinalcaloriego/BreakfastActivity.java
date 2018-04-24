package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BreakfastActivity extends AppCompatActivity {
    private ArrayList<Food> food;
    private BreakfastAdapter breakfastAdapter;
    private EditText breakfastCalorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_breakfast);
        setContentView(R.layout.activity_breakfast);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);
        initialData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        breakfastCalorie = findViewById(R.id.enter_calorie);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        breakfastAdapter = new BreakfastAdapter(food, this);
        recyclerView.setAdapter(breakfastAdapter);
    }


    private void initialData() {
        food = new ArrayList<>();
        food.add(new Food("A cup of whole milk（200ml)", "108", R.drawable.milk));
        food.add(new Food("A bowl of porridge（200ml)", "92", R.drawable.porridge));
        food.add(new Food("A piece of bread（100g)", "312", R.drawable.bread));
        food.add(new Food("A boiled egg(100g)", "144", R.drawable.boiledegg));
        food.add(new Food("Cereal(100g) with whole milk(100ml)", "200", R.drawable.cereal));
        food.add(new Food("A cup of coffee(100ml，with milk and sugar)", "420", R.drawable.coffee));
        food.add(new Food("An apple(150g)", "83", R.drawable.apple));
    }

    public void finish(View view){
        Intent backIntent = new Intent(this, FoodActivity.class);
        startActivity(backIntent);
        int bfCalorie = Integer.valueOf(breakfastCalorie.getText().toString());
        backIntent.putExtra(Keys.CALORIE_DATA, bfCalorie);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.add:
//                food.add(foodInfo());
//                breakfastAdapter.notifyDataSetChanged();
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }


//    private Food foodInfo() {
//        String name = foodText.getText().toString();
//        String calorie = calText.getText().toString();
//        return new Food(name,calorie,R.drawable.defaultpic);}
//
//
//    public void addItem(View view) {
//        food.add(foodInfo());
//        breakfastAdapter.notifyDataSetChanged();
//    }


}


