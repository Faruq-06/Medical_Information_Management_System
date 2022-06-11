package com.example.mims.ModelClasses;

public class NurseRegistrationModel {
    String fullname;
    String fa_name;
    String w_number;
    String speciality;
    String phone;
    String email;
    String address;
    String password;

    public NurseRegistrationModel() {
    }

    public NurseRegistrationModel(String fullname, String fa_name, String w_number,
                                  String speciality, String phone, String email,
                                  String address, String password) {
        this.fullname = fullname;
        this.fa_name = fa_name;
        this.w_number = w_number;
        this.speciality = speciality;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFa_name() {
        return fa_name;
    }

    public void setFa_name(String fa_name) {
        this.fa_name = fa_name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
