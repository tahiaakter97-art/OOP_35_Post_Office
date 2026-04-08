package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class Transaction {
    private int transactionId;
    private int userId;
    private float amount;
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(int transactionId, float amount, int userId, LocalDate date) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.userId = userId;
        this.date = date;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
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
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", userId=" + userId +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
