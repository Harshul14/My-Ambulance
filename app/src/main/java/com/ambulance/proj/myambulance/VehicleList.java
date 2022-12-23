package com.ambulance.proj.myambulance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class VehicleList extends AppCompatActivity {

    Button btnAdd;
    ListView listView ;
    VehicleAdapter vehicleAdapter;
    ArrayList<Vehicle> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_list);

        btnAdd = findViewById(R.id.btnAdd);

        arrayList = new ArrayList<Vehicle>();
        arrayList.add(new Vehicle("maruti","100","This is siple ambulance"));


        listView = findViewById(R.id.vehicle_list);
        setList();

        //employeeAdapter.notifyDataSetChanged();
       // listViewEmp.setOnItemClickListener(this);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddVehicleDetails.class));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("", "onResume: ");
        Vehicle vehicle = (Vehicle) getIntent().getSerializableExtra("vehicle");
        if(vehicle != null) {
           // arrayList.add(new Vehicle("maruti", "100", "NA"));
            arrayList.add(vehicle);
            setList();
        }
    }

    public void setList(){
        vehicleAdapter = new VehicleAdapter(this,arrayList);
        listView.setAdapter(vehicleAdapter);
    }
}