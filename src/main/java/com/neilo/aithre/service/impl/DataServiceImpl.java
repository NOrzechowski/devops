package com.neilo.aithre.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neilo.aithre.dto.ChartDataDto;
import com.neilo.aithre.entity.Skill;
import com.neilo.aithre.repository.SkillRepository;
import com.neilo.aithre.repository.EmployeeRepository;
import com.neilo.aithre.service.DataService;
import com.neilo.aithre.service.EmployeeService;

@Service
public class DataServiceImpl implements DataService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	SkillRepository skillRepository;

	@Override
	public ChartDataDto getCircleChartData() {
		List<String> legends = new ArrayList<>();
		List<Integer> values = new ArrayList<>();

		Set<String> results = skillRepository.findAll()
		        .stream()
		        .map(Skill::getSkillName)
		        .collect(Collectors.toSet());
		
		for (String skill : results) {
			legends.add(skill);
			values.add(employeeService.getEmployeesBySkillName(skill).size());
		}

		return new ChartDataDto(legends, values);
	}

}
