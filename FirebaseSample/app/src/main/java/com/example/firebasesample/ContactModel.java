package com.example.firebasesample;

public class ContactModel
{
    String name;
    String mobNo;

    public ContactModel(String name, String mobNo) {
        this.name = name;
        this.mobNo = mobNo;
    }
    ContactModel(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
