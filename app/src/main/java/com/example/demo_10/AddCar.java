package com.example.demo_10;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddCar extends AppCompatActivity {

    //we will use these constants later to pass the car name and id to another activity
    public static final String CAR_MAKE = "com.example.demo_10.carMake";
    public static final String CAR_REG = "com.example.demo_10.carRegistration";
    public static final String CAR_ID = "com.example.demo_10.carId";

    //view objects
    EditText editTextCarRegistration;
    EditText editTextCarMake;
    EditText editTextCarModel;
    Button buttonAddCar;
    ListView listViewCars;

    //a list to store all the car from firebase database
    List<Car> cars;

    //our database reference object
    DatabaseReference databaseCars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_car);

        //getting the reference of cars node
        databaseCars = FirebaseDatabase.getInstance().getReference("cars");

        //getting views
        editTextCarRegistration = findViewById(R.id.editTextCarRegistration);
        editTextCarModel = findViewById(R.id.editTextCarModel);
        editTextCarMake = findViewById(R.id.editTextCarMake);
        listViewCars = (ListView) findViewById(R.id.listViewCars);

        buttonAddCar = (Button) findViewById(R.id.buttonAddCar);

        //list to store cars
        cars = new ArrayList<>();


        //adding an onclicklistener to button
        buttonAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //calling the method addCar()
                //the method is defined below
                //this method is actually performing the write operation
                addCar();
            }
        });
        listViewCars.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //getting the selected car
                Car car = cars.get(i);

                //creating an intent
                Intent intent = new Intent(getApplicationContext(), LogNewIncident.class);

                //putting car name and id to intent
                intent.putExtra(CAR_ID, car.getCarId());
                intent.putExtra(CAR_REG, car.getCarRegistration());

                //starting the activity with intent
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        //attaching value event listener
        databaseCars.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //clearing the previous car list
                cars.clear();

                //iterating through all the nodes
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    //getting car
                    Car car = postSnapshot.getValue(Car.class);
                    //adding car to the list
                    cars.add(car);
                }

                //creating adapter
                CarList carAdapter = new CarList(AddCar.this, cars);
                //attaching adapter to the listview
                listViewCars.setAdapter(carAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    /*
     * This method is saving a new car to the
     * Firebase Realtime Database
     * */
    private void addCar() {


        //getting the values to save
        String registration = editTextCarRegistration.getText().toString().trim();
        String make = editTextCarMake.getText().toString().trim();
        String model = editTextCarModel.getText().toString().trim();

        //checking if the value is provided
        if (!TextUtils.isEmpty(registration)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Car
            String id = databaseCars.push().getKey();

            //creating an Car Object
            Car car = new Car(id, registration, make, model);

            //Saving the Car
            databaseCars.child(id).setValue(car);

            //setting edittext to blank again
            editTextCarRegistration.setText("");
            editTextCarMake.setText("");
            editTextCarModel.setText("");

            //displaying a success toast
            Toast.makeText(this, "Car added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a registration", Toast.LENGTH_LONG).show();
        }
    }
}