package com.example.demo_10;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Belal on 2/26/2017.
 */

public class IncidentList extends ArrayAdapter<Incident> {
    private Activity context;
    List<Incident> incidents;

    public IncidentList(Activity context, List<Incident> incidents) {
        super(context, R.layout.layout_car_list, incidents);
        this.context = context;
        this.incidents = incidents;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_car_list, null, true);

        TextView textViewLocation = (TextView) listViewItem.findViewById(R.id.textViewMake);
        TextView textViewDateTime = (TextView) listViewItem.findViewById(R.id.textViewModel);

        Incident incident = incidents.get(position);
        textViewLocation.setText(incident.getLocation());
        textViewDateTime.setText(String.valueOf(incident.getDateTime()));

        return listViewItem;
    }
}