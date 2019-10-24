package com.restapi.springbootapiexample2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.springbootapiexample2.model.Employee;
import com.restapi.springbootapiexample2.dao.EmployeeDAO;
@RestController
@RequestMapping("/company")
public class EmployeeController {
	@Autowired
    EmployeeDAO employeeDAO;
	/*to save en employee */
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp){
		return employeeDAO.save(emp);
	}
	/* get all the employees*/
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeDAO.findAll();
	}
	/* get employee by a particular empid*/
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value="id") Long empid){
		Employee emp = employeeDAO.findOne(empid);
		if(emp == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
	}
	/*update an Employee by empid*/
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value="id") Long empid,@Valid @RequestBody Employee empDetails)
	{
		Employee emp = employeeDAO.findOne(empid);
		if(emp == null){
			return ResponseEntity.notFound().build();
		}
		emp.setName(empDetails.getName());
		emp.setDesignation(empDetails.getDesignation());
		emp.setExpertise(empDetails.getExpertise());
		
		Employee updateEmployee = employeeDAO.save(emp);
		return ResponseEntity.ok().body(updateEmployee); 
	}
	
	/*delete an employee*/
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable(value="id") Long empid){
		Employee emp = employeeDAO.findOne(empid);
		if(emp == null){
			return ResponseEntity.notFound().build();
		}
		employeeDAO.delete(emp);
		return ResponseEntity.ok().build();
	}
	

	
}
	
