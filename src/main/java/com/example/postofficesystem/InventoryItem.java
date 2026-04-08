package com.example.postofficesystem;

public class InventoryItem {
    private int itemId;
    private String name;
    private float quantity;
    private float price;
    private int minRequired;
    private String status;


    public InventoryItem(String s) {
    }

    public InventoryItem(int itemId, String name, float quantity, float price, int minRequired, String status) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.minRequired = minRequired;
        this.status = status;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getMinRequired() {
        return minRequired;
    }

    public void setMinRequired(int minRequired) {
        this.minRequired = minRequired;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "InventoryItem{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", minRequired=" + minRequired +
                ", status='" + status + '\'' +
                '}';
    }
}
