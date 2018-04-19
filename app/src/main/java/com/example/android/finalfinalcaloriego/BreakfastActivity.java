package com.example.android.finalfinalcaloriego;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class BreakfastActivity extends AppCompatActivity {
    private ArrayList<Breakfast> breakfast;
    private BreakfastAdapter breakfastAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast);

        initialData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        breakfastAdapter = new BreakfastAdapter(breakfast, this);
        recyclerView.setAdapter(breakfastAdapter);
    }

    private void initialData() {
        breakfast = new ArrayList<>();
        breakfast.add(new Breakfast("A cup of whole milk（200ml)", "108", R.drawable.milk));
        breakfast.add(new Breakfast("A bowl of porridge（200ml)", "92", R.drawable.porridge));
        breakfast.add(new Breakfast("A piece of bread（100g)", "312", R.drawable.bread));
        breakfast.add(new Breakfast("A boiled egg(100g)", "144", R.drawable.boiledegg));
        breakfast.add(new Breakfast("Cereal(100g) with whole milk(100ml)", "200", R.drawable.cereal));
        breakfast.add(new Breakfast("A cup of coffee(100ml，with milk and sugar", "420", R.drawable.coffee));
        breakfast.add(new Breakfast("An apple(150g)", "83", R.drawable.apple));
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
}

//    private Breakfast addFood(){
//
//    }
//}
