package com.example.demo_10;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MyInformation extends AppCompatActivity {

    //declaring buttons
    private Button toMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_information);

        //setting buttons to their id's
        toMenu = (Button)findViewById(R.id.b_to_menu);

        //setting listeners for buttons
        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MyInformation.this, Menu.class);
                startActivity(menu);
            }
        });
    }

}
