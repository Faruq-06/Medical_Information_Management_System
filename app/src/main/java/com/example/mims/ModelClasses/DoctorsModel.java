package com.example.mims.ModelClasses;

public class DoctorsModel {
    private String fullname;
    private String e_mail;
    private String Specialist;

    public DoctorsModel() {
    }

    public DoctorsModel(String fullname, String e_mail, String specialist) {
        this.fullname = fullname;
        this.e_mail = e_mail;
        Specialist = specialist;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public String getSpecialist() {
        return Specialist;
    }

    public void setSpecialist(String specialist) {
        Specialist = specialist;
    }
}
