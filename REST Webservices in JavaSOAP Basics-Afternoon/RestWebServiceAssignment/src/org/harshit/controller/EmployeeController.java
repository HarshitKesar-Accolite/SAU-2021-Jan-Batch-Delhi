package org.harshit.controller;

import java.util.List;
 
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.harshit.bean.Employee;
import org.harshit.service.EmployeeService;

@Path("/employees")
public class EmployeeController {

	EmployeeService serviceObj = new EmployeeService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getUsers()
	{
		return serviceObj.getAllEmployees();
	}
	
	
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object getEmployeeByID(@PathParam("id") int id)
	{
		Employee empObj = serviceObj.getEmployeeById(id);
		if(empObj == null)
			return "No Employee exists with this ID.";
		return empObj;
	}
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Employee addUser(Employee empObj)
	{
		return serviceObj.addEmployee(empObj);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Employee updateUser(Employee empObj)
	{
		return serviceObj.updateEmployee(empObj);
	}
	
	
	@DELETE
	@Path("{id}")
	public String deleteUser(@PathParam("id") int id)
	{
		return serviceObj.deleteEmployee(id) ? "Deleted Successfully" : "No Employee exists with this ID" ;
	}
}
