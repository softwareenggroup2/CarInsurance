package com.example.demo_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogIn extends AppCompatActivity {

    //declaring buttons
    private Button login;
    private Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        // hi
        //setting buttons to their id's
        login = (Button)findViewById(R.id.b_login);
        back = (Button)findViewById(R.id.b_back);

        //setting listeners for buttons
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(LogIn.this, Menu.class);
                startActivity(menu);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(LogIn.this, Main.class);
                startActivity(back);
            }
        });
    }
}
