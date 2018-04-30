package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    Button signUp;
    Button logIn;
    FirebaseDatabase database;
    DatabaseReference users;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

}

    public void logIn(View view) {
        logIn = findViewById(R.id.login);
        Intent logInIntent;
        logInIntent = new Intent(this, LoginActivity.class);
        startActivity(logInIntent);
    }


    public void signUp(View view) {
        signUp = findViewById(R.id.sign_up1);
        Intent signUpIntent;
        signUpIntent = new Intent(this, InformationActivity.class);
        startActivity(signUpIntent);
    }
}
