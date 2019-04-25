package com.example.demo_10;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Belal on 2/26/2017.
 */
@IgnoreExtraProperties
public class Car {
    private String registration;
    private String carMake;
    private String carModel;
    private String carId;

    public Car(){
        //this constructor is required
    }

    public Car(String CarId, String registration, String carMake, String carModel) {
        this.registration = registration;
        this.carMake = carMake;
        this.carModel = carModel;
        this.carId = carId;
    }

    public String getCarId() {
        return carId;
    }

    public String getCarRegistration() {
        return registration;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarMake() {
        return carMake;
    }
}