package com.example.postofficesystem.Mahfuz.model;

public class Charge {

    private double weight;
    private String distance;
    private String serviceType;
    private double totalCharge;

    public Charge(double weight, String distance, String serviceType, double totalCharge) {
        this.weight = weight;
        this.distance = distance;
        this.serviceType = serviceType;
        this.totalCharge = totalCharge;
    }

    public double getWeight() {
        return weight;
    }

    public String getDistance() {
        return distance;
    }

    public String getServiceType() {
        return serviceType;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public String toCSV() {
        return weight + "," + distance + "," + serviceType + "," + totalCharge;
    }
}