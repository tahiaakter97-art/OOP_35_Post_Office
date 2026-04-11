package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class DeliveryIncome {

    private int deliveryId;
    private String serviceType;
    private float amount;
    private String paymentMode;
    private String status;
    private LocalDate date;


    public DeliveryIncome(int deliveryId, String serviceType, float amount, String paymentMode, String status, LocalDate date) {
        this.deliveryId = deliveryId;
        this.serviceType = serviceType;
        this.amount = amount;
        this.paymentMode = paymentMode;
        this.status = status;
        this.date = date;
    }


    public DeliveryIncome() {
    }


    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
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

    public String getDateString() {
        return date.toString();
    }

    @Override
    public String toString() {
        return "DeliveryIncome{" +
                "deliveryId=" + deliveryId +
                ", serviceType='" + serviceType + '\'' +
                ", amount=" + amount +
                ", paymentMode='" + paymentMode + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}