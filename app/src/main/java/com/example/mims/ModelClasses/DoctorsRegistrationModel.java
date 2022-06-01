package com.example.mims.ModelClasses;

public class DoctorsRegistrationModel {
    String fullname;
    String father_name;
    String mother_name;
    String a_ge;
    String Phone;
    String E_mail;
    String Address;
    String password;

    public DoctorsRegistrationModel() {
    }

    public DoctorsRegistrationModel(String fullname,String father_name,
                                    String mother_name,String a_ge,String Phone,
                                    String E_mail, String Address, String password) {
        this.fullname = fullname;
        this.father_name = father_name;
        this.mother_name = mother_name;
        this.a_ge=a_ge;
        this.Phone = Phone;
        this.E_mail = E_mail;
        this.Address = Address;
        this.password = password;

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFather_name() {
        return father_name;
    }

    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public String getA_ge() {
        return a_ge;
    }

    public void setA_ge(String a_ge) {
        this.a_ge = a_ge;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getE_mail() {
        return E_mail;
    }

    public void setE_mail(String e_mail) {
        E_mail = e_mail;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
