package com.example.votingapp;

public class Votersdb {

    private  String name;
    private String  voterID;
    private String aadhar;
    private String dob;
    private String address;
    private String phone;

    public Votersdb(){

    }
    public Votersdb(String name, String voterID,String aadhar,String dob, String address,String phone)
    {
        this.voterID = voterID;
        this.dob = dob;
        this.name = name;
        this.aadhar = aadhar;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoterID() {
        return voterID;
    }

    public void setVoterID(String voterID) {
        this.voterID = voterID;
    }

    public String getAadhar() {
        return aadhar;
    }

    public void setAadhar(String aadhar) {
        this.aadhar = aadhar;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
