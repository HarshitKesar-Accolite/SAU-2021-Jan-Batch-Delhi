package service;

import model.Employee;
import notification.NotificationMode;
import notification.emailNotification;
import notification.phoneNotification;

public class Service {
    public static void setService(Employee employee, char modeOfCommunication){
        NotificationMode notification;

        if(modeOfCommunication == '1' || modeOfCommunication == '3') {
            notification = new emailNotification();
            notification.getNotification(employee);
        }
        if(modeOfCommunication == '2' || modeOfCommunication == '3'){
            notification = new phoneNotification();
            notification.getNotification(employee);
        }
    }
}
