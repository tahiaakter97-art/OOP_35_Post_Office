package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class Report {
    private int reportId;
    private String title;
    private String content;
    private LocalDate date;

    public Report() {

    }

    public Report(int reportId, String title, String content, LocalDate date) {
        this.reportId = reportId;
        this.title = title;
        this.content = content;
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

    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
