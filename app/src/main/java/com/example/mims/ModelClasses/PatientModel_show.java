package com.example.mims.ModelClasses;

public class PatientModel_show {
    String fullname;
    String phone;
    String id;

    public PatientModel_show() {
    }

    public PatientModel_show(String fullname, String phone, String id) {
        this.fullname = fullname;
        this.phone = phone;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
