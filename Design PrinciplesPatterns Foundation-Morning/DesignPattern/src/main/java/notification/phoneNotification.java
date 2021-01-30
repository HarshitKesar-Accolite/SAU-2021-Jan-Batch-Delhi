package notification;

import model.Employee;

public class phoneNotification extends NotificationMode{

    @Override
    public void getNotification(Employee employee) {
        System.out.print("Salary Credited to " + employee.getName() + " on SMS Notification.");
        employee.displaySalary();
    }
}
