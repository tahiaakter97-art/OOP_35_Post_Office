package com.example.postofficesystem;

import java.time.LocalDate;

public class Report {

    private int serialNumber;
    private String title;
    private String content;
    private LocalDate date;

    public Report() {
    }

    public Report(int serialNumber, String title, String content, LocalDate date) {
        this.serialNumber = serialNumber;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Report{" +
                "serialNumber=" + serialNumber +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}