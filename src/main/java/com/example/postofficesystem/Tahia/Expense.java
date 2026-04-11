package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class Expense {

    private int expenseId;
    private String expenseType;
    private float amount;
    private String referenceNo;
    private LocalDate dueDate;
    private String status; // Paid / Pending


    public Expense() {
    }

    public Expense(int expenseId, String expenseType, float amount,
                   String referenceNo, LocalDate dueDate, String status) {
        this.expenseId = expenseId;
        this.expenseType = expenseType;
        this.amount = amount;
        this.referenceNo = referenceNo;
        this.dueDate = dueDate;
        this.status = status;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "expenseId=" + expenseId +
                ", expenseType='" + expenseType + '\'' +
                ", amount=" + amount +
                ", referenceNo='" + referenceNo + '\'' +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                '}';
    }
}