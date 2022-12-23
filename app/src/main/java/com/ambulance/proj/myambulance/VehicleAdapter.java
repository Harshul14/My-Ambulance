package com.ambulance.proj.myambulance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class VehicleAdapter extends BaseAdapter {

    Context context;
    ArrayList<Vehicle> arrayListVehicle;

    public VehicleAdapter(Context context,ArrayList<Vehicle> arrayListVehicle){
        this.context = context;
        this.arrayListVehicle = arrayListVehicle;
    }

    @Override
    public int getCount() {

        return arrayListVehicle.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayListVehicle.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
            view = LayoutInflater.from(context).inflate(R.layout.list_vehicle,viewGroup,false);

        Vehicle currentVehicle = (Vehicle)getItem(i);
        TextView textName = (TextView) view.findViewById(R.id.text_vehicle_name);
        TextView textCost = (TextView) view.findViewById(R.id.text_cost);
        TextView textDes = (TextView) view.findViewById(R.id.text_des);
        ImageView img = (ImageView) view.findViewById(R.id.img);

        textName.setText(currentVehicle.getVehicleName());
        textCost.setText(currentVehicle.getCost());
        textDes.setText(currentVehicle.getDescription());

        return view;
    }
}
