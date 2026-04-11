package com.example.postofficesystem.Tahia;

public class Delivery {
    private int deliveryId;
    private String mailType; // Letter / Parcel
    private String receiverName;
    private String address;
    private String status;

    public Delivery() {
    }

    public Delivery(int deliveryId, String mailType, String receiverName, String address, String status) {
        this.deliveryId = deliveryId;
        this.mailType = mailType;
        this.receiverName = receiverName;
        this.address = address;
        this.status = status;
    }

    public int getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(int deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "deliveryId=" + deliveryId +
                ", mailType='" + mailType + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", address='" + address + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
