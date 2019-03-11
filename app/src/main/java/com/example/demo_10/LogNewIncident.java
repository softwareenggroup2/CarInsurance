package com.example.demo_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogNewIncident extends AppCompatActivity {

    //declaring buttons
    private Button submit;
    private Button toMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_new_incident);

        //setting buttons to their id's
        submit = (Button)findViewById(R.id.b_submit);
        toMenu = (Button)findViewById(R.id.b_to_menu);

        //setting listeners for buttons
        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(LogNewIncident.this, Menu.class);
                startActivity(menu);
            }
        });
    }
}
