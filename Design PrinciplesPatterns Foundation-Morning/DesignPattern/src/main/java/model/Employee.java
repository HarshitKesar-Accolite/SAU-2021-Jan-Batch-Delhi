package model;

public abstract class Employee {
    private int id;
    private String name;
    private String emailId;
    private String phone;
    private double salary;
    private char notificationMode;

    public abstract void displaySalary();

    public Employee(int id, String name, String emailId, String phone, char notificationMode) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.phone = phone;
        this.notificationMode = notificationMode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public char getNotificationMode() {
        return notificationMode;
    }

    public void setNotificationMode(char notificationMode) {
        this.notificationMode = notificationMode;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", emailId='" + emailId + '\'' +
                ", phone='" + phone + '\'' +
                ", notificationMode=" + notificationMode +
                '}';
    }
}
