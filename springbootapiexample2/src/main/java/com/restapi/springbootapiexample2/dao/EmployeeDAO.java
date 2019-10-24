package com.restapi.springbootapiexample2.dao;


import java.util.List;

import com.restapi.springbootapiexample2.model.Employee;
import com.restapi.springbootapiexample2.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDAO {
	
	@Autowired
	EmployeeRepository employeeRepository;
	/*to save an employee */
	public Employee save(Employee emp){
		return employeeRepository.save(emp);
	}
	/*to search an employee*/
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	/*get/update an employee*/
	public Employee findOne(Long empid){
		return employeeRepository.findOne(empid);
	}
	
	/*delete an employee*/
	public void delete(Employee emp){
		employeeRepository.delete(emp);
	}
}
