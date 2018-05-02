package com.example.android.finalfinalcaloriego;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
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
    private FirebaseAuth mrAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        database = FirebaseDatabase.getInstance();
        users = database.getReference("Users");
        mrAuth = FirebaseAuth.getInstance();

        userEditText = (EditText) findViewById(R.id.UserText);
        passwordEditText = (EditText) findViewById(R.id.PasswordText);
        btnlogIn = findViewById(R.id.login);
        signUp = findViewById(R.id.sign_up2);

//        btnlogIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                logIn(userEditText.getText().toString(),
//                        passwordEditText.getText().toString());
//
//            }
//        });

    }
    public void logIn(View view)
    {
        String email = userEditText.getText().toString();
        String password = passwordEditText.getText().toString();
       if(email.isEmpty()||password.isEmpty()){
           Toast.makeText(LoginActivity.this,"Please enter valid email addres and password", Toast.LENGTH_SHORT).show();
       }
       else {
           mrAuth.signInWithEmailAndPassword(email, password)
                   .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (!task.isSuccessful()) {
                               Toast.makeText(LoginActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();

                           } else {
                               Toast.makeText(LoginActivity.this, task.getResult().getUser().getEmail() + " logged in successful",
                                       Toast.LENGTH_SHORT).show();
                               Intent s = new Intent(getApplicationContext(), MeActivity.class);
                               startActivity(s);
                               finish();
                           }
                       }
                   });
       }
    }




}
