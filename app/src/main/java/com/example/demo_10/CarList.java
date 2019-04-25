package com.example.demo_10;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Belal on 2/26/2017.
 */

public class CarList extends ArrayAdapter<Car> {
    private Activity context;
    List<Car> cars;

    public CarList(Activity context, List<Car> cars) {
        super(context, R.layout.layout_car_list, cars);
        this.context = context;
        this.cars = cars;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.layout_car_list, null, true);


        TextView textViewMake = (TextView) listViewItem.findViewById(R.id.textViewMake);
        TextView textViewModel = (TextView) listViewItem.findViewById(R.id.textViewModel);
        Car car = cars.get(position);
        textViewModel.setText(car.getCarModel());
        textViewMake.setText(car.getCarMake());

        return listViewItem;
    }
}
