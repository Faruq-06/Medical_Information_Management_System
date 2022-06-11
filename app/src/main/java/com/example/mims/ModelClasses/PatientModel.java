package com.example.mims.ModelClasses;

public class PatientModel {
    String fullname;
    String age;
    String phone;
    String email;
    String password;

    public PatientModel() {
    }

    public PatientModel(String fullname, String age, String phone, String email, String password) {
        this.fullname = fullname;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
