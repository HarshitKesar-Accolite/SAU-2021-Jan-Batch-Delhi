package model;

public class DevIntern extends Employee{
    private double salary = 20000;

    public DevIntern(int id, String name, String emailId, String phone, char notificationMode) {
        super(id, name, emailId, phone, notificationMode);
    }

    @Override
    public void displaySalary() {
        System.out.println(this.salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
