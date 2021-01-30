package main;

import factory.EmployeeFactory;
import model.Employee;
import service.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String args[]){
        System.out.println("\n ========= PaySquare Application =========");

        Map<String , Employee> employeeList = new HashMap<>();

        employeeList.put("101", EmployeeFactory.getEmployee(101,"Harsh", "harshit@accolitedigital.com","7827246763",'1',"DevIntern"));
        employeeList.put("102", EmployeeFactory.getEmployee(102,"Kesar", "kesar@accolitedigital.com","1234569845", '2',"Manager"));
        employeeList.put("103", EmployeeFactory.getEmployee(103,"Abcd", "abcd@accolitedigital.com","2356486512",'1',"SDE"));
        employeeList.put("104", EmployeeFactory.getEmployee(104,"Pqrs", "pqrs@accolitedigital.com","6532148654",'1',"DevIntern"));
        employeeList.put("105", EmployeeFactory.getEmployee(105,"Xyzw", "xyzw@accolitedigital.com","9854632175",'2',"SDE"));

        for (String i : employeeList.keySet()) {
            Employee employee =  employeeList.get(i);
            Service.setService(employee, employee.getNotificationMode());
        }
    }
}
