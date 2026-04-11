package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class MailRecord {
    private int mailId;
    private int senderId;
    private int receiverId;
    private LocalDate date;
    private String status;
    private String type;

    public MailRecord() {
    }

    public MailRecord(int mailId, int senderId, int receiverId, LocalDate date, String status, String type) {
        this.mailId = mailId;
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.date = date;
        this.status = status;
        this.type = type;
    }

    public int getMailId() {
        return mailId;
    }

    public void setMailId(int mailId) {
        this.mailId = mailId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "MailRecord{" +
                "mailId=" + mailId +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
