package com.example.postofficesystem.Tahia;

public class Income {

    private String serviceName;
    private float amount;
    private int transactionCount;
    private String month;
    private int year;

    public Income() {
    }

    public Income(String serviceName, float amount, int transactionCount, String month, int year) {
        this.serviceName = serviceName;
        this.amount = amount;
        this.transactionCount = transactionCount;
        this.month = month;
        this.year = year;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Income{" +
                "serviceName='" + serviceName + '\'' +
                ", amount=" + amount +
                ", transactionCount=" + transactionCount +
                ", month='" + month + '\'' +
                ", year=" + year +
                '}';
    }
}
