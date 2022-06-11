package com.example.mims.ModelClasses;

public class AppointmentModel {
    String department;
    String name;
    String age;
    String gender;
    String time;
    String token;

    public AppointmentModel() {
    }

    public AppointmentModel(String department, String name, String age, String gender, String time, String token) {
        this.department = department;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.time = time;
        this.token = token;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
