package com.ambulance.proj.myambulance;

import java.io.Serializable;

public class Vehicle implements Serializable {

    private String vehicleName;
    private String cost;
    private String description;

    public Vehicle(String vehicleName, String cost, String description) {
        this.vehicleName = vehicleName;
        this.cost = cost;
        this.description = description;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
