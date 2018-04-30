package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {


    FirebaseDatabase database;
    DatabaseReference users;
    EditText userEditText;
    EditText passwordEditText;
    Button signUp;
    Button btnlogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");

        userEditText = (EditText) findViewById(R.id.UserText);
        passwordEditText = (EditText) findViewById(R.id.PasswordText);
        btnlogIn = findViewById(R.id.login);
        signUp = findViewById(R.id.sign_up2);
        btnlogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logIn(userEditText.getText().toString(),
                        passwordEditText.getText().toString());

            }
        });

    }


    public void logIn(final String username, final String password) {
        users.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                if (dataSnapshot.child(username).exists()) {
                    if (!username.isEmpty()) {
                        User login = dataSnapshot.child(username).getValue(User.class);
                        if (login.getPassword().equals(password)) {
                            Toast.makeText(LoginActivity.this, "Success Login", Toast.LENGTH_SHORT).show();
                            Intent s = new Intent(getApplicationContext(), MeActivity.class);
                            startActivity(s);


                        } else {
                            Toast.makeText(LoginActivity.this, "Password is wrong", Toast.LENGTH_SHORT).show();
                        }
                    } else
                        Toast.makeText(LoginActivity.this, "User name is not registered", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }
}
