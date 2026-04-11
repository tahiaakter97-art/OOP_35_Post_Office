package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class FinancialReport {
    private int reportId;
    private String title;
    private double totalIncome;
    private double totalExpense;
    private String details;
    private String status;
    private LocalDate date;

    public FinancialReport() {
    }

    public FinancialReport(int reportId, String title, double totalIncome, double totalExpense, String details, String status, LocalDate date) {
        this.reportId = reportId;
        this.title = title;
        this.totalIncome = totalIncome;
        this.totalExpense = totalExpense;
        this.details = details;
        this.status = status;
        this.date = date;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "FinancialReport{" +
                "reportId=" + reportId +
                ", title='" + title + '\'' +
                ", totalIncome=" + totalIncome +
                ", totalExpense=" + totalExpense +
                ", details='" + details + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
