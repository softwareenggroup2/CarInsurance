package com.example.demo_10;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ViewPastIncidents extends AppCompatActivity {

    //declaring buttons
    private Button viewInc;
    private Button toMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pat_incidents);

        //setting buttons to their id's
        viewInc = (Button)findViewById(R.id.b_rand_inc);
        toMenu = (Button)findViewById(R.id.b_to_menu);

        //setting listeners for buttons
        viewInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(ViewPastIncidents.this, RandomIncident.class);
                startActivity(add);
            }
        });
        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(ViewPastIncidents.this, Menu.class);
                startActivity(menu);
            }
        });
    }

}
