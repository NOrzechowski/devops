package com.neilo.aithre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neilo.aithre.dto.EmployeeDto;
import com.neilo.aithre.service.EmployeeService;
import com.neilo.aithre.utils.Constants;


@RequestMapping("/employee")
@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(Constants.GET_EMPLOYEE_BY_ID)
	public EmployeeDto getEmployeeById(@PathVariable Integer employeeId) {
		return employeeService.getEmployeeById(employeeId);
	}
	
	@RequestMapping(Constants.GET_ALL_EMPLOYEES)
	public List<EmployeeDto> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value= Constants.SAVE_EMPLOYEE, method= RequestMethod.POST)
	public void saveEmployee(@RequestBody EmployeeDto employeeDto) {
		employeeService.saveEmployee(employeeDto);
	}
}
