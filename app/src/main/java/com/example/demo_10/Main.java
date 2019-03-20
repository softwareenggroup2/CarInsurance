package com.example.demo_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    //TESTING THAT GIT CONNECTION IS WORKING.
    //declaring click ons
   private Button logIn;
   private TextView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_log);

        //setting buttons to their id's
        logIn = (Button) findViewById(R.id.b_login);
        signIn = (TextView) findViewById(R.id.text_sign_up);

        //setting listeners
        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(Main.this, Menu.class);
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

}
