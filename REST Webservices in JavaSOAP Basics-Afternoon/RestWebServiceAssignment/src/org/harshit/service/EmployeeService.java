package org.harshit.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.harshit.bean.Employee;

public class EmployeeService {
	
	static HashMap<Integer,Employee> empObj=new HashMap<>();
	static int currentId=0;

	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		List<Employee> allEmployees= new ArrayList<>(empObj.values());
		return allEmployees;
	}

	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		if(!empObj.containsKey(id))
			return null;
		return empObj.get(id);
	}

	public Employee addEmployee(Employee emp) {
		// TODO Auto-generated method stub
		emp.setId(++currentId);
		empObj.put(currentId, emp);
		return empObj.get(currentId);
	}

	public Employee updateEmployee(Employee user) {
		// TODO Auto-generated method stub
		empObj.put(user.getId(), user);
		return user;
	}

	public boolean deleteEmployee(int id) {
		// TODO Auto-generated method stub
		if(empObj.containsKey(id))
			return false;
		empObj.remove(id);
		return true;
	}

}
