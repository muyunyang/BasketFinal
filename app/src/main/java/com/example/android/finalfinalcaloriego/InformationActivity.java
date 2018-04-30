package com.example.android.finalfinalcaloriego;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



public class InformationActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference userReference;
    private FirebaseAuth mrAuth=FirebaseAuth.getInstance();

    private FirebaseAuth msAuth=FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener authListener;
    EditText nameText;
    EditText ageText;
    EditText genderText;
    EditText heightText;
    EditText weightText;

    EditText emailText;
    EditText passwordEditText;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        emailText = (EditText) findViewById(R.id.emailText);
        passwordEditText = (EditText) findViewById(R.id.PasswordText);
        nameText = (EditText) findViewById(R.id.nameText);
        ageText = findViewById(R.id.ageText);

        heightText = findViewById(R.id.heightText);
        weightText = findViewById(R.id.weightText);

        signUp = findViewById(R.id.sign_up2);


        userReference = database.getReference("CodedUser");

        msAuth = FirebaseAuth.getInstance();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    userReference = database.getReference(user.getUid());
                } else {
                    startActivity(new Intent(InformationActivity.this, LoginActivity.class));
                }
            }
        };

    }




    public void sendToFirebase(View view) {
        String email =  emailText.getText().toString();
        String password =  passwordEditText.getText().toString();
        String name =  nameText.getText().toString();
        String age =  ageText.getText().toString();

        String height =  heightText.getText().toString();
        String weight =  weightText.getText().toString();
        double BMI;
        int calorie;

        User user = new User(email,password,name,age,height,weight);
        userReference.child(name).setValue(user);

        Intent s= new Intent(this,MeActivity.class                                                                                                                                                                                                                  );
        startActivity(s);

        mrAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (!task.isSuccessful())
                        {
                            Toast.makeText(InformationActivity.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(InformationActivity.this, task.getResult().getUser().getEmail() + " signed up successful",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });
    }

    public void logout(View view){msAuth.signOut();}
}