package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class Expense {
    private int expenseId;
    private String description;
    private float amount;
    private LocalDate date;

    public Expense() {
    }

    public Expense(int expenseId, String description, float amount, LocalDate date) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
