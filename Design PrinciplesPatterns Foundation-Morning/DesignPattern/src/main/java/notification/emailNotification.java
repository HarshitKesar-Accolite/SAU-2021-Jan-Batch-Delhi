package notification;

import model.Employee;

public class emailNotification extends NotificationMode{

    @Override
    public void getNotification(Employee employee) {
        System.out.print("Salary Credited to " + employee.getName() + " on Email Notification.");
        employee.displaySalary();
    }
}
