package com.example.demo_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyInsuranceInfo extends AppCompatActivity {

    //declaring buttons
    private Button add;
    private Button toMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_insurance_info);

        //setting buttons to their id's
        toMenu = (Button)findViewById(R.id.b_to_menu);
        add = (Button)findViewById(R.id.addbut);

        //setting listeners for buttons
        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(MyInsuranceInfo.this, Menu.class);
                startActivity(menu);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(MyInsuranceInfo.this, AddCar.class);
                startActivity(add);
            }
        });
    }
}
