package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class Payment {

    private String transactionId;
    private String customerName;
    private float amount;
    private String paymentType;
    private LocalDate date;
    private String status;
    private String description;

    public Payment() {
    }

    public Payment(String transactionId, String customerName, float amount, String paymentType, LocalDate date, String status, String description) {
        this.transactionId = transactionId;
        this.customerName = customerName;
        this.amount = amount;
        this.paymentType = paymentType;
        this.date = date;
        this.status = status;
        this.description = description;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "transactionId='" + transactionId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", amount=" + amount +
                ", paymentType='" + paymentType + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
