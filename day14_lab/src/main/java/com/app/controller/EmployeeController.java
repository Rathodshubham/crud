package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
 
	@Autowired
	private EmployeeService empService;

	public EmployeeController() {
		System.out.println("in ctor of " + getClass());
	}
 
	@GetMapping
	public List<Employee> listAllEmps() {
		System.out.println("in list all emps");
		return empService.getAllEmps();
	}
 
	@PostMapping
	public Employee addEmpDetails(@RequestBody Employee newEmp)
 	{
		System.out.println("in add emp " + newEmp);
		return empService.addEmpDetails(newEmp);
 	}

 
	@DeleteMapping("/{empId}")
 
	public String deleteEmpDetails(@PathVariable Long empId) {
		System.out.println("in del emp dtls " + empId);
		return empService.deleteEmpDetails(empId);
	}

 
	@GetMapping("/{empId}")
	public Employee getEmpDetails(@PathVariable Long empId) {
		System.out.println("in get emp dtls " + empId);
		return empService.getEmpDetails(empId);
	}
 
	@PutMapping
	public Employee updateEmpDetails(@RequestBody Employee emp)
	{
		System.out.println("in update emp details");
		return empService.updateEmpDetails(emp);
	}

}
