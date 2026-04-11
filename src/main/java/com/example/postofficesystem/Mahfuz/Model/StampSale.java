package com.example.postofficesystem.Mahfuz.model;

public class StampSale {

    private String stampType;
    private int quantity;
    private int unitPrice;
    private int totalPrice;

    public StampSale(String stampType, int quantity, int unitPrice, int totalPrice) {
        this.stampType = stampType;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public String getStampType() { return stampType; }
    public int getQuantity() { return quantity; }
    public int getUnitPrice() { return unitPrice; }
    public int getTotalPrice() { return totalPrice; }

    public String toCSV() {
        return stampType + "," + quantity + "," + unitPrice + "," + totalPrice;
    }
}