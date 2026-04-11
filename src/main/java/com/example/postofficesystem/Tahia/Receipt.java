package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class Receipt {
    private int receiptId;
    private int transactionId;
    private String customerName;
    private String serviceType;
    private float amount;
    private LocalDate date;

    public Receipt() {
    }

    public Receipt(int receiptId, int transactionId, String customerName,
                   String serviceType, float amount, LocalDate date) {
        this.receiptId = receiptId;
        this.transactionId = transactionId;
        this.customerName = customerName;
        this.serviceType = serviceType;
        this.amount = amount;
        this.date = date;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
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
                ", transactionId=" + transactionId +
                ", customerName='" + customerName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}