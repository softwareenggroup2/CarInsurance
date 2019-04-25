package com.example.demo_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LogNewIncident extends AppCompatActivity {

    Button buttonAddIncident;
    EditText editTextIncidentLocation;
    EditText editTextIncidentDateTime;
    EditText editTextIncidentDescription;
    SeekBar seekBarRating;
    TextView textViewRating, textViewCar;
    ListView listViewIncidents;

    DatabaseReference databaseIncidents;

    List<Incident> incidents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_new_incident);

        Intent intent = getIntent();

        /*
         * this line is important
         * this time we are not getting the reference of a direct node
         * but inside the node incident we are creating a new child with the car id
         * and inside that node we will store all the incidents with unique ids
         * */
        databaseIncidents = FirebaseDatabase.getInstance().getReference("incidents").child(intent.getStringExtra(AddCar.CAR_ID));
        //databaseIncidents = FirebaseDatabase.getInstance().getReference("incidents").child("-LdFC4AZyUs9M_KFVj_L");
        buttonAddIncident = (Button) findViewById(R.id.b_submit);
        editTextIncidentLocation = (EditText) findViewById(R.id.editTextLocation);
        editTextIncidentDateTime = (EditText) findViewById(R.id.editTextTimeAndDate);
        editTextIncidentDescription = (EditText) findViewById(R.id.editTextDescription);
        textViewRating = (TextView) findViewById(R.id.textViewMake);
        textViewCar = (TextView) findViewById(R.id.textViewModel);
        listViewIncidents = (ListView) findViewById(R.id.listViewIncidents);

        incidents = new ArrayList<>();

        textViewCar.setText(intent.getStringExtra(AddCar.CAR_MAKE));



        buttonAddIncident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveIncident();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseIncidents.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                incidents.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Incident incident = postSnapshot.getValue(Incident.class);
                    incidents.add(incident);
                }
                IncidentList incidentListAdapter = new IncidentList(LogNewIncident.this, incidents);
                listViewIncidents.setAdapter(incidentListAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void saveIncident() {
        String incidentLocation = editTextIncidentLocation.getText().toString().trim();
        String incidentDateTime = editTextIncidentDateTime.getText().toString().trim();
        String incidentDescription = editTextIncidentDescription.getText().toString().trim();
        int rating = seekBarRating.getProgress();
        if (!TextUtils.isEmpty(incidentLocation)) {
            String id  = databaseIncidents.push().getKey();
            Incident incident = new Incident(id, incidentLocation, incidentDateTime, incidentDescription);
            databaseIncidents.child(id).setValue(incident);
            Toast.makeText(this, "Incident saved", Toast.LENGTH_LONG).show();
            editTextIncidentLocation.setText("");
        } else {
            Toast.makeText(this, "Please enter incident name", Toast.LENGTH_LONG).show();
        }
    }
}
