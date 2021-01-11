package com.example.au.couchbasedemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.au.couchbasedemo.model.Employee;
import com.example.au.couchbasedemo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    /*
	 * @RequestMapping("/") public String index() { return
	 * "Welcome to the CRUD application!!"; }
	 */
    
    //ADD NEW EMPLOYEE
    @PostMapping("/employee")
    public Employee addEmployeePost(@RequestBody Employee newEmployee) {
        return employeeRepository.save(newEmployee);
    }
    
    //GET EMPLOYEE BY ID
    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable String id) {
        if (employeeRepository.existsById(id)) {
            return employeeRepository.findById(id);
        } else
            return Optional.empty();
    }
    
    //GET EMPLOYEE BY EMPLOYEE NAME
    @GetMapping("/employee/name/{name}")
    public Employee getEmployeeByEmployeeName(@PathVariable String name) {
        return employeeRepository.findByEmpName(name);
    }
    
    //GET EMPLOYEE BY LOCATION
    @GetMapping("/employee/address/{address}")
    public Employee getEmployeeByEmployeeLocation(@PathVariable String address) {
        return employeeRepository.findByAddress(address);
    }
    
    @DeleteMapping("/employee/{id}") //working
    public void deleteById(@PathVariable String id) {
      employeeRepository.deleteById(id);
    }
}