package com.example.demo_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {

    //declaring buttons
    private Button signup;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        //setting buttons to their id's
      signup = (Button)findViewById(R.id.b_signin);
      back = (Button)findViewById(R.id.b_back);


      //setting listeners for buttons
      signup.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent menu = new Intent(SignUp.this, Menu.class);
              startActivity(menu);
          }
      });
      back.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent back = new Intent(SignUp.this, Main.class);
              startActivity(back);
          }
      });


    }
}
