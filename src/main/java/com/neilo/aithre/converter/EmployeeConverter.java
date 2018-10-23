package com.neilo.aithre.converter;

import java.util.stream.Collectors;

import com.neilo.aithre.dto.EmployeeDto;
import com.neilo.aithre.entity.Employee;


public class EmployeeConverter {
	public static Employee dtoToEntity(EmployeeDto employeeDto) {
		Employee employee = new Employee(employeeDto.getEmployeeName(), null);
		employee.setEmployeeId(employeeDto.getEmployeeId());
		employee.setSkills(employeeDto.getSkillDtos().stream().map(SkillConverter::dtoToEntity).collect(Collectors.toList()));
		return employee;
	}

	public static EmployeeDto entityToDto(Employee employee) {
		EmployeeDto employeeDto = new EmployeeDto(employee.getEmployeeId(), employee.getEmployeeName(), null);
		employeeDto.setSkillDtos(employee.getSkills().stream().map(SkillConverter::entityToDto).collect(Collectors.toList()));
		return employeeDto;
	}
}
