package com.example.postofficesystem.Mahfuz.model;

public class ParcelTrack {

    private String trackingId;
    private String senderName;
    private String receiverName;
    private String receiverAddress;
    private String status;

    private String failureReason;
    private String rescheduleDate;

    // ✅ NEW FIELD (IMPORTANT FOR RETURN LOGIC)
    private int attemptCount;

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

        // default attempt
        this.attemptCount = 0;
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

    // ✅ NEW: attempt count getter/setter
    public int getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    // ================= FILE FORMAT =================
    public String toFileString() {
        return trackingId + "," +
                senderName + "," +
                receiverName + "," +
                receiverAddress + "," +
                status + "," +
                (failureReason == null ? "" : failureReason) + "," +
                (rescheduleDate == null ? "" : rescheduleDate) + "," +
                attemptCount;
    }
}