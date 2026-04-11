package com.example.postofficesystem.Tahia;

public class RefundRequest {

    private int requestId;
    private int userId;
    private float amount;
    private String reason;
    private String status;

    // Constructor
    public RefundRequest(int requestId, int userId, float amount, String reason, String status) {
        this.requestId = requestId;
        this.userId = userId;
        this.amount = amount;
        this.reason = reason;
        this.status = status;
    }

    // Default Constructor (optional but good practice)
    public RefundRequest() {
    }

    // Getters
    public int getRequestId() {
        return requestId;
    }

    public int getUserId() {
        return userId;
    }

    public float getAmount() {
        return amount;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
