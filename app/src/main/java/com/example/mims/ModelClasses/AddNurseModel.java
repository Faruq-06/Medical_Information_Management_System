package com.example.mims.ModelClasses;

public class AddNurseModel {
    String fullname;
    String phone;
    String email;
    String w_number;
    String speciality;
    String password;

    public AddNurseModel() {
    }

    public AddNurseModel(String fullname, String phone, String email, String w_number, String speciality, String password) {
        this.fullname = fullname;
        this.phone = phone;
        this.email = email;
        this.w_number = w_number;
        this.speciality = speciality;
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getW_number() {
        return w_number;
    }

    public void setW_number(String w_number) {
        this.w_number = w_number;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
