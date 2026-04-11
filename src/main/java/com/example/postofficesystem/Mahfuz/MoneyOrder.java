package com.example.postofficesystem.Mahfuz;

import java.io.Serializable;

public class MoneyOrder implements Serializable {
    private static final long serialVersionUID = 1L;

    private String moneyOrderId;
    private String senderName;
    private String receiverName;
    private double amount;
    private double serviceCharge;
    private double totalPayable;
    private String date;

    public MoneyOrder() {
    }

    public MoneyOrder(String moneyOrderId, String senderName, String receiverName,
                      double amount, double serviceCharge, double totalPayable, String date) {
        this.moneyOrderId = moneyOrderId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.amount = amount;
        this.serviceCharge = serviceCharge;
        this.totalPayable = totalPayable;
        this.date = date;
    }

    public String getMoneyOrderId() {
        return moneyOrderId;
    }

    public void setMoneyOrderId(String moneyOrderId) {
        this.moneyOrderId = moneyOrderId;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public double getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(double totalPayable) {
        this.totalPayable = totalPayable;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MoneyOrder{" +
                "moneyOrderId='" + moneyOrderId + '\'' +
                ", senderName='" + senderName + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", amount=" + amount +
                ", serviceCharge=" + serviceCharge +
                ", totalPayable=" + totalPayable +
                ", date='" + date + '\'' +
                '}';
    }
}