package com.example.postofficesystem;

import java.time.LocalDate;

public class Requisition {
    private int requisitionId;
    private int itemId;
    private int quantity;
    private LocalDate date;

    public Requisition() {
    }

    public Requisition(int requisitionId, int itemId, int quantity, LocalDate date) {
        this.requisitionId = requisitionId;
        this.itemId = itemId;
        this.quantity = quantity;
        this.date = date;
    }

    public Requisition(LocalDate date, int requisitionId, int itemId, int quantity) {
        this.date = date;
        this.requisitionId = requisitionId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public int getRequisitionId() {
        return requisitionId;
    }

    public void setRequisitionId(int requisitionId) {
        this.requisitionId = requisitionId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Requisition{" +
                "requisitionId=" + requisitionId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
