package com.neilo.aithre.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neilo.aithre.converter.EmployeeConverter;
import com.neilo.aithre.dto.EmployeeDto;
import com.neilo.aithre.entity.Employee;
import com.neilo.aithre.repository.EmployeeRepository;
import com.neilo.aithre.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto getEmployeeById(Integer employeeId) {
		return EmployeeConverter.entityToDto(employeeRepository.getOne(employeeId));
	}

	@Override
	public void saveEmployee(EmployeeDto employeeDto) {
		employeeRepository.save(EmployeeConverter.dtoToEntity(employeeDto));
	}

	@Override
	public List<EmployeeDto> getAllEmployees() {
		return employeeRepository.findAll().stream().map(EmployeeConverter::entityToDto).collect(Collectors.toList());
	}
	
	@Override
	public List<EmployeeDto> getEmployeesBySkillName(String skillName) {	
		List<EmployeeDto> employees = new ArrayList<EmployeeDto>();
		for(Employee employee :  employeeRepository.findAll()) {
			 boolean exists = employee.getSkills().stream()
			            .anyMatch(t -> t.getSkillName().equals(skillName));
			 if(exists) {
				 employees.add(EmployeeConverter.entityToDto(employee));
			 }
		}
		return employees;
	}
	
	@Override
	public List<EmployeeDto> getEmployeesBySkillId(Integer skillId) {	
		List<EmployeeDto> employees = new ArrayList<EmployeeDto>();
		for(Employee employee :  employeeRepository.findAll()) {
			 boolean exists = employee.getSkills().stream()
			            .anyMatch(t -> t.getSkillId().equals(skillId));
			 if(exists) {
				 employees.add(EmployeeConverter.entityToDto(employee));
			 }
		}
		return employees;
	}
}
