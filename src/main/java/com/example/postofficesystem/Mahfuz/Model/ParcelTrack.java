package com.example.postofficesystem.Mahfuz.model;

public class ParcelTrack {

    private String trackingId;
    private String senderName;
    private String receiverName;
    private String receiverAddress;
    private String status;

    public ParcelTrack() {}

    public ParcelTrack(String trackingId, String senderName,
                       String receiverName, String receiverAddress,
                       String status) {
        this.trackingId = trackingId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.status = status;
    }

    public String getTrackingId() { return trackingId; }
    public String getSenderName() { return senderName; }
    public String getReceiverName() { return receiverName; }
    public String getReceiverAddress() { return receiverAddress; }
    public String getStatus() { return status; }

    public void setStatus(String status) {
        this.status = status;
    }
}