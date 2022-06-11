package com.example.mims.ModelClasses;

public class PatientModel_show {
    String fullname;
    String phone;

    public PatientModel_show() {
    }

    public PatientModel_show(String fullname, String phone) {
        this.fullname = fullname;
        this.phone = phone;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
