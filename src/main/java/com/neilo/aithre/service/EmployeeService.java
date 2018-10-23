package com.neilo.aithre.service;

import java.util.List;

import com.neilo.aithre.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto getEmployeeById(Integer employeeId);

	void saveEmployee(EmployeeDto employeeDto);

	List<EmployeeDto> getAllEmployees();

	List<EmployeeDto> getEmployeesBySkillName(String skillName);

	List<EmployeeDto> getEmployeesBySkillId(Integer skillId);
}
