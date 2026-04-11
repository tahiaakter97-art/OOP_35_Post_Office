package com.example.postofficesystem.Mahfuz.model;

public class Letter {

    private String registrationNo;
    private String senderName;
    private String receiverName;
    private String receiverAddress;
    private String letterType;
    private double charge;
    private String date;

    public Letter(String registrationNo, String senderName,
                  String receiverName, String receiverAddress,
                  String letterType, double charge, String date) {

        this.registrationNo = registrationNo;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.letterType = letterType;
        this.charge = charge;
        this.date = date;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public String toCSV() {
        return registrationNo + "," +
                senderName + "," +
                receiverName + "," +
                receiverAddress + "," +
                letterType + "," +
                charge + "," +
                date;
    }
}