package com.example.postofficesystem.Tahia;

import java.time.LocalDate;

public class MailRecord {
    private int mailId;
    private int senderId;
    private int receiverId;
    private LocalDate date;
    private String status;

    public MailRecord() {
    }

    public int getMailId() {
        return mailId;
    }

    public int getSenderId() {
        return senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMailId(int mailId) {
        this.mailId = mailId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    @Override
    public String toString() {
        return "MailRecord{" +
                "mailId=" + mailId +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }
}
