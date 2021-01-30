package notification;

import model.Employee;

public abstract class NotificationMode {
    public abstract void getNotification(Employee employee);
}
