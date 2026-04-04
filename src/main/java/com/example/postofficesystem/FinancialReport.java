package com.example.postofficesystem;

import java.time.LocalDate;

public class FinancialReport {
    private int reportId;
    private double totalIncome;
    private double totalExpense;
    private LocalDate date;

    public FinancialReport() {
    }

    public FinancialReport(int reportId, double totalIncome, double totalExpense, LocalDate date) {
        this.reportId = reportId;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(double totalExpense) {
        this.totalExpense = totalExpense;
    }

    @Override
    public String toString() {
        return "FinancialReport{" +
                "reportId=" + reportId +
                ", totalIncome=" + totalIncome +
                ", totalExpense=" + totalExpense +
                ", date=" + date +
                '}';
    }
}
