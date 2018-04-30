package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MeActivity extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference myReference;
    EditText emailText;
    TextView passwordEditText;
    Button btnme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_me);
        emailText = (EditText) findViewById(R.id.Text1);
        passwordEditText = (TextView) findViewById(R.id.name_enter);

        database = FirebaseDatabase.getInstance();
        btnme = findViewById(R.id.Text2);

    }


    public void readFromCloud(View view) {
        String referenceId = emailText.getText().toString();
        myReference = database.getReference("CodedUser");
        myReference.child(referenceId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    User user = dataSnapshot.getValue(User.class);
                    String loadedData = "Age: " + user.getAgeText() + "\nHeight: " + user.getHeightText() + "cm" + "\nWeight: " + user.getWeightText() + " kg";
                    double weight = Double.valueOf(user.getWeightText());
                    double height = Double.valueOf(user.getHeightText());
                    double BMI = weight / (height * height / 10000);
                    int calorie;

                    if (BMI > 23) {
                        calorie = 1800;
                    } else if (BMI < 18) {
                        calorie = 2200;
                    } else {
                        calorie = 2000;
                    }

                    passwordEditText.setText(loadedData + "\nBMI: " + BMI + "\nCalorie: " + calorie + "kcal");
                } else {
                    passwordEditText.setText(null);
                    Toast.makeText(MeActivity.this, "Cannot find the key!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MeActivity.this, "Error loading Firebase", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void food(View view) {
        Intent foodIntent = new Intent(this, TabbedActivity.class);
        startActivity(foodIntent);
    }

}