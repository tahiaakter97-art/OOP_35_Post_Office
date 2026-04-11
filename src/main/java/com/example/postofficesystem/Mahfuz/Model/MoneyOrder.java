package com.example.postofficesystem.Mahfuz.model;

public class MoneyOrder {

    private String moneyOrderId;
    private String senderName;
    private String receiverName;
    private double amount;
    private double serviceCharge;
    private double totalPayable;

    public MoneyOrder(String moneyOrderId, String senderName,
                      String receiverName, double amount,
                      double serviceCharge, double totalPayable) {

        this.moneyOrderId = moneyOrderId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.amount = amount;
        this.serviceCharge = serviceCharge;
        this.totalPayable = totalPayable;
    }

    public String getMoneyOrderId() {
        return moneyOrderId;
    }

    public String toCSV() {
        return moneyOrderId + "," +
                senderName + "," +
                receiverName + "," +
                amount + "," +
                serviceCharge + "," +
                totalPayable;
    }
}