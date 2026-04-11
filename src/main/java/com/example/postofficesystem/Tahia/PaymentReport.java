package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class PaymentReport {

    private int paymentId;
    private String senderName;
    private String receiverName;
    private float amount;
    private LocalDate date;
    private String status;

    public PaymentReport() {
    }

    public PaymentReport(int paymentId, String senderName, String receiverName,
                         float amount, LocalDate date, String status) {
        this.paymentId = paymentId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.amount = amount;
        this.date = date;
        this.status = status;
    }


    public int getPaymentId() {
        return paymentId;
    }

    public String getSenderName() {
        return senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public float getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }


    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentReport{" +
                "paymentId=" + paymentId +
                ", senderName='" + senderName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}