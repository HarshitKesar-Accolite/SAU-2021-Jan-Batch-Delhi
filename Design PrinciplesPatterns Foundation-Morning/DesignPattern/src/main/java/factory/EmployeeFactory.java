package factory;

import model.DevIntern;
import model.Employee;
import model.Manager;
import model.SDE;

public class EmployeeFactory {
    public static Employee getEmployee(int id, String name, String email, String phone, char notificationMode, String designation){
        designation = designation.toUpperCase();
        Employee employee;
        if(designation.equals("SDE")){
            employee = new SDE(id, name, email, phone, notificationMode);
        }
        else if(designation.equals("MANAGER")){
            employee = new Manager(id, name, email, phone, notificationMode);
        }
        else{
            employee = new DevIntern(id, name, email, phone, notificationMode);
        }
        return employee;
    }
}
