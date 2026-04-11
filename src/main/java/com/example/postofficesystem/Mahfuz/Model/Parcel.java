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

    // Getters
    public String getTrackingId() { return trackingId; }
    public String getSenderName() { return senderName; }
    public String getSenderPhone() { return senderPhone; }
    public String getReceiverName() { return receiverName; }
    public String getReceiverPhone() { return receiverPhone; }
    public String getReceiverAddress() { return receiverAddress; }
    public double getWeight() { return weight; }
    public String getParcelType() { return parcelType; }
    public double getCharge() { return charge; }
    public String getStatus() { return status; }
    public String getDate() { return date; }

    // Convert to CSV format
    public String toCSV() {
        return trackingId + "," + senderName + "," + senderPhone + "," +
                receiverName + "," + receiverPhone + "," +
                receiverAddress + "," + weight + "," +
                parcelType + "," + charge + "," +
                status + "," + date;
    }
}