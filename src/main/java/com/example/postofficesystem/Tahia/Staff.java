package com.example.postofficesystem.Tahia;

public class Staff {
        private int staffId;
        private String name;
        private String role; //Postman ,CounterClerk,Accountant//
        private String status; //Present,Absent//
        private float salary;

    public Staff() {
    }

    public Staff(int staffId, String name, String status, String role, float salary) {
        this.staffId = staffId;
        this.name = name;
        this.status = status;
        this.role = role;
        this.salary = salary;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "staffId=" + staffId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                ", salary=" + salary +
                '}';
    }
}
