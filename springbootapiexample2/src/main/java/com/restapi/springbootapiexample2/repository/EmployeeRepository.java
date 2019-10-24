package com.restapi.springbootapiexample2.repository;
import com.restapi.springbootapiexample2.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

