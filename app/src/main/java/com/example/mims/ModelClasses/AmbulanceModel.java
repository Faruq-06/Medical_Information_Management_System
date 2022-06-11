package com.example.mims.ModelClasses;

public class AmbulanceModel {
    String Name;
    String Mobile;
    String Vehicle_number;

    public AmbulanceModel() {
    }

    public AmbulanceModel(String name, String mobile, String vehicle_number) {
        Name = name;
        Mobile = mobile;
        Vehicle_number = vehicle_number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getVehicle_number() {
        return Vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        Vehicle_number = vehicle_number;
    }
}
