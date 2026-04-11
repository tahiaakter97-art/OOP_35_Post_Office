package com.example.postofficesystem.Mahfuz.model;

public class Parcel {

    private String trackingId;
    private String senderName;
    private String senderPhone;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private double weight;
    private String parcelType;
    private double charge;
    private String status;
    private String date;

    public Parcel() {
    }

    public Parcel(String trackingId, String senderName, String senderPhone,
                  String receiverName, String receiverPhone,
                  String receiverAddress, double weight,
                  String parcelType, double charge,
                  String status, String date) {
        this.trackingId = trackingId;
        this.senderName = senderName;
        this.senderPhone = senderPhone;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.receiverAddress = receiverAddress;
        this.weight = weight;
        this.parcelType = parcelType;
        this.charge = charge;
        this.status = status;
        this.date = date;
    }

    // Getters & Setters

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getParcelType() {
        return parcelType;
    }

    public void setParcelType(String parcelType) {
        this.parcelType = parcelType;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return trackingId + "," + senderName + "," + senderPhone + "," +
                receiverName + "," + receiverPhone + "," +
                receiverAddress + "," + weight + "," +
                parcelType + "," + charge + "," +
                status + "," + date;
    }
}