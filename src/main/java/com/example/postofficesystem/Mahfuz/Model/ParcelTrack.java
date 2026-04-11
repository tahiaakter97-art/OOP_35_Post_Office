package com.example.postofficesystem.Mahfuz.model;

public class ParcelTrack {

    private String trackingId;
    private String senderName;
    private String receiverName;
    private String receiverAddress;
    private String status;

    private String failureReason;
    private String rescheduleDate;
    private int attemptCount;

    // ✅ NEW (for Collect Signature feature)
    private String receiverSignature;

    public ParcelTrack() {
    }

    public ParcelTrack(String trackingId,
                       String senderName,
                       String receiverName,
                       String receiverAddress,
                       String status) {

        this.trackingId = trackingId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.status = status;

        this.failureReason = "";
        this.rescheduleDate = "";
        this.attemptCount = 0;
        this.receiverSignature = "";
    }

    // ================= GETTERS & SETTERS =================

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

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }

    public String getRescheduleDate() {
        return rescheduleDate;
    }

    public void setRescheduleDate(String rescheduleDate) {
        this.rescheduleDate = rescheduleDate;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    // ✅ NEW: Signature
    public String getReceiverSignature() {
        return receiverSignature;
    }

    public void setReceiverSignature(String receiverSignature) {
        this.receiverSignature = receiverSignature;
    }

    // ================= FILE FORMAT =================
    public String toFileString() {
        return trackingId + "," +
                senderName + "," +
                receiverName + "," +
                receiverAddress + "," +
                status + "," +
                failureReason + "," +
                rescheduleDate + "," +
                attemptCount + "," +
                receiverSignature;
    }
}