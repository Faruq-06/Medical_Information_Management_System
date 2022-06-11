package com.example.mims.ModelClasses;

public class NurseModel {
    String fullname;
    String phone;
    String w_number;
    String email;
    String speciality;
    String password;
    String id;

    public NurseModel() {
    }

    public NurseModel(String fullname, String phone, String w_number, String email, String speciality, String password, String id) {
        this.fullname = fullname;
        this.phone = phone;
        this.w_number = w_number;
        this.email = email;
        this.speciality = speciality;
        this.password = password;
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

    public String getW_number() {
        return w_number;
    }

    public void setW_number(String w_number) {
        this.w_number = w_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
