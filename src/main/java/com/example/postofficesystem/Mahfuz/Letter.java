package com.example.postofficesystem.Mahfuz;

import java.io.Serializable;

public class Letter implements Serializable {
    private static final long serialVersionUID = 1L;

    private String registrationNo;
    private String senderName;
    private String senderAddress;
    private String receiverName;
    private String receiverAddress;
    private String letterType;
    private double charge;
    private String date;

    public Letter() {
    }

    public Letter(String registrationNo, String senderName, String senderAddress,
                  String receiverName, String receiverAddress,
                  String letterType, double charge, String date) {
        this.registrationNo = registrationNo;
        this.senderName = senderName;
        this.senderAddress = senderAddress;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.letterType = letterType;
        this.charge = charge;
        this.date = date;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public String getLetterType() {
        return letterType;
    }

    public void setLetterType(String letterType) {
        this.letterType = letterType;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "registrationNo='" + registrationNo + '\'' +
                ", senderName='" + senderName + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", letterType='" + letterType + '\'' +
                ", charge=" + charge +
                ", date='" + date + '\'' +
                '}';
    }
}