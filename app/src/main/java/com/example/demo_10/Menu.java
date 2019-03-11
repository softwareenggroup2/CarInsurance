package com.example.demo_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    //declaring buttons
    private Button logIncident;
    private Button viewIncidents;
    private Button myInformation;
    private Button myInsuranece;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //setting buttons to their id's
        logIncident = (Button)findViewById(R.id.b_log_incident);
        viewIncidents = (Button)findViewById(R.id.b_past_incidents);
        myInformation = (Button)findViewById(R.id.b_my_info);
        myInsuranece = (Button)findViewById(R.id.b_insurance_info);
        logout = (Button)findViewById(R.id.b_logout);

        //setting listeners for buttons
        logIncident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent log = new Intent(Menu.this, LogNewIncident.class);
                startActivity(log);
            }
        });
        viewIncidents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pinc = new Intent(Menu.this, ViewPastIncidents.class);
                startActivity(pinc);
            }
        });
        myInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent minf = new Intent(Menu.this, MyInformation.class);
                startActivity(minf);
            }
        });
        myInsuranece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mins = new Intent(Menu.this, MyInsuranceInfo.class);
                startActivity(mins);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main = new Intent(Menu.this, Main.class);
                startActivity(main);
            }
        });

    }
}
