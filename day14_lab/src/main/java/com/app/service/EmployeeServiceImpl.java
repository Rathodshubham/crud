package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.EmployeeDao;
import com.app.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
 
	@Autowired
	private EmployeeDao empDao;

	@Override
	public List<Employee> getAllEmps() {
 		return empDao.findAll();
	}

	@Override
	public Employee addEmpDetails(Employee newEmp) {
 		return empDao.save(newEmp);  
	} 

	@Override
	public String deleteEmpDetails(Long empId) {
		if(empDao.existsById(empId)) {
			empDao.deleteById(empId);
			return "Deleted emp details....";
		}
		return "Invalid emp id !!!!!!";
	}

	@Override
	public Employee getEmpDetails(Long empId) {
		
		return empDao.findById(empId).orElseThrow(() -> 
		new ResourceNotFoundException("Invalid Emp ID !!!!"));
	}
  

	@Override
	public Employee updateEmpDetails(Employee emp) {
 		return empDao.save(emp);
	}
	
	
	
	
	

}
