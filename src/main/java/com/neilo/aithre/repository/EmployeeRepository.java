package com.neilo.aithre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.neilo.aithre.entity.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
