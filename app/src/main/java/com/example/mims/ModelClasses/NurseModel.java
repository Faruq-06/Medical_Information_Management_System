package com.example.mims.ModelClasses;

public class NurseModel {
    String fullname;
    String phone;
    String w_number;

    public NurseModel() {
    }

    public NurseModel(String fullname, String phone, String w_number) {
        this.fullname = fullname;
        this.phone = phone;
        this.w_number = w_number;
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

    public String getW_number() {
        return w_number;
    }

    public void setW_number(String w_number) {
        this.w_number = w_number;
    }
}
