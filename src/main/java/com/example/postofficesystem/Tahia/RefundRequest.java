package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class RefundRequest {
    private int requestId;
    private int userId;
    private float amount;
    private String status;
    private LocalDate date;

    public RefundRequest() {
    }

    public RefundRequest(int requestId, float amount, int userId, String status, LocalDate date) {
        this.requestId = requestId;
        this.amount = amount;
        this.userId = userId;
        this.status = status;
        this.date = date;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RefundRequest{" +
                "requestId=" + requestId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
