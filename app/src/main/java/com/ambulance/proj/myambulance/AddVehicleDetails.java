package com.ambulance.proj.myambulance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class AddVehicleDetails extends AppCompatActivity {

    Button btnAdd;
    EditText editTextName,editTextCost,editTextDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vehicle_details);

        btnAdd = findViewById(R.id.btnAddVehicle);
        editTextName = findViewById(R.id.edit_name);
        editTextCost = findViewById(R.id.edit_cost);
        editTextDes = findViewById(R.id.edit_des);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getVehicleDetails();
            }
        });


    }
    public void getVehicleDetails(){
        String name = editTextName.getText().toString();
        String cost = editTextCost.getText().toString();
        String des = editTextDes.getText().toString();

        Vehicle vehicle = new Vehicle(name,cost,des);

        Intent intent = new Intent(getApplicationContext(),VehicleList.class);
        intent.putExtra("vehicle", (Serializable) vehicle);
        startActivity(intent);

    }
}