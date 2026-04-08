package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class Receipt {
    private int receiptId;
    private int userId;
    private float amount;
    private LocalDate date;

    public Receipt() {
    }

    public Receipt(int receiptId, int userId, float amount, LocalDate date) {
        this.receiptId = receiptId;
        this.userId = userId;
        this.amount = amount;
        this.date = date;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "receiptId=" + receiptId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
