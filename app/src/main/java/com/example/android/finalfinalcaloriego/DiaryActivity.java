package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.finalfinalcaloriego.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DiaryActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference myReference;
    EditText keyField;
    EditText valueField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle("Food Diary");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        keyField = findViewById(R.id.date_Text);
        valueField = findViewById(R.id.diary_Text);
        database = FirebaseDatabase.getInstance();
    }
    public void writeToCloud(View view) {
        myReference = database.getReference(keyField.getText().toString());
        myReference.setValue(valueField.getText().toString());
    }

    public void readFromCloud(View view){
        myReference = database.getReference(keyField.getText().toString());
        myReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    String loadedData = dataSnapshot.getValue(String.class);
                    valueField.setText(loadedData);
                }
                else{
                    valueField.setText(null);
                    Toast.makeText(DiaryActivity.this, "Cannot find the key!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(DiaryActivity.this, "Error loading Firebase", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void me(View view){
        Intent meIntent = new Intent (this, MeActivity.class);
        startActivity(meIntent);
    }

    public void food(View view){
        Intent foodIntent = new Intent(this, FoodActivity.class);
        startActivity(foodIntent);
    }

//    public void news(View view){
//        Intent newsIntent = new Intent(this, NewsAct)
//    }
}
