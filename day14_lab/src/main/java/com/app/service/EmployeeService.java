package com.app.service;

import java.util.List;

import com.app.entities.Employee;

public interface EmployeeService {
	List<Employee> getAllEmps();
	Employee addEmpDetails(Employee newEmp);
	String deleteEmpDetails(Long empId);
	Employee getEmpDetails(Long empId);
	Employee updateEmpDetails(Employee emp);
}
