package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class Announcement {
    private int announcementId;
    private String title;
    private String message;
    private LocalDate date;

    public Announcement() {
    }

    public Announcement(int announcementId, String title, String message, LocalDate date) {
        this.announcementId = announcementId;
        this.title = title;
        this.message = message;
        this.date = date;
    }

    public int getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(int announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId=" + announcementId +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
