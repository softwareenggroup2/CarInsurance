package com.example.demo_10;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Belal on 2/26/2017.
 */
@IgnoreExtraProperties
public class Incident {
    private String id;
    private String location;
    private String dateTime;
    private String description;

    public Incident() {

    }

    public Incident(String id, String location, String dateTime, String description) {
        this.location = location;
        this.dateTime = dateTime;
        this.id = id;
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }
}