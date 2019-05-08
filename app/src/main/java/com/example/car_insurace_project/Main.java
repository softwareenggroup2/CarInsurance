package com.example.car_insurace_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Main extends AppCompatActivity {

    //TESTING THAT GIT CONNECTION IS WORKING.
    //declaring click ons
    private Button logIn;
    private TextView signIn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // Initialise Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);

        //setting buttons to their id's
        logIn = (Button) findViewById(R.id.b_login);
        signIn = (TextView) findViewById(R.id.text_sign_up);

        //setting listeners
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Main.this, LoggedInMain.class);
                startActivity(menu);
            }
        });
        //not yet tested
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Main.this, SignUp.class);
                startActivity(menu);
            }
        });

    }

    private void updateUI(FirebaseUser currentUser) {
        Toast.makeText(getBaseContext(), "This is my Toast message!",
                Toast.LENGTH_LONG).show();

    }

}
