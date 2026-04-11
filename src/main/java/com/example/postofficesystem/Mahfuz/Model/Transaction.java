package com.example.postofficesystem.Mahfuz.model;

public class Transaction {

    private String date;
    private int totalBookings;
    private double totalIncome;

    public Transaction(String date, int totalBookings, double totalIncome) {
        this.date = date;
        this.totalBookings = totalBookings;
        this.totalIncome = totalIncome;
    }

    public String toCSV() {
        return date + "," + totalBookings + "," + totalIncome;
    }
}