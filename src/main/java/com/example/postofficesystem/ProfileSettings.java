package com.example.postofficesystem;

public class ProfileSettings {

    private String officeHours;
    private String contactNumber;
    private String emergencyNotice;

    public ProfileSettings() {
    }

    public ProfileSettings(String officeHours, String contactNumber, String emergencyNotice) {
        this.officeHours = officeHours;
        this.contactNumber = contactNumber;
        this.emergencyNotice = emergencyNotice;
    }


    public String getOfficeHours() {
        return officeHours;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmergencyNotice() {
        return emergencyNotice;
    }


    public void setOfficeHours(String officeHours) {
        this.officeHours = officeHours;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmergencyNotice(String emergencyNotice) {
        this.emergencyNotice = emergencyNotice;
    }

    @Override
    public String toString() {
        return "ProfileSettings{" +
                "officeHours='" + officeHours + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", emergencyNotice='" + emergencyNotice + '\'' +
                '}';
    }
}