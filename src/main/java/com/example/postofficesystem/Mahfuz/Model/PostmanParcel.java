package com.example.postofficesystem.Mahfuz.model;

import java.time.LocalDate;

public class PostmanParcel {

    private String trackingId;
    private String receiverName;
    private String receiverAddress;
    private String status;
    private int failedAttempts;
    private LocalDate deliveryDate;
    private String damageType;
    private String signature;
    private String assignedPostman;

    public PostmanParcel() {
    }

    public PostmanParcel(String trackingId, String receiverName,
                         String receiverAddress, String status,
                         int failedAttempts, LocalDate deliveryDate,
                         String damageType, String signature,
                         String assignedPostman) {

        this.trackingId = trackingId;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.status = status;
        this.failedAttempts = failedAttempts;
        this.deliveryDate = deliveryDate;
        this.damageType = damageType;
        this.signature = signature;
        this.assignedPostman = assignedPostman;
    }

    // Getters & Setters

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getAssignedPostman() {
        return assignedPostman;
    }

    public void setAssignedPostman(String assignedPostman) {
        this.assignedPostman = assignedPostman;
    }
}