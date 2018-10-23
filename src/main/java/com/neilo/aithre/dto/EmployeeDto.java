package com.neilo.aithre.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class EmployeeDto {
	Integer employeeId;
	String employeeName;
	List<SkillDto> skillDtos = new ArrayList<>();
	String skillsCsv;

	public EmployeeDto(Integer employeeId, String employeeName, List<SkillDto> skillDtos) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.skillDtos = skillDtos;
		if (!Objects.isNull(skillDtos))
			this.skillsCsv = skillDtos.stream().map(e -> e.getSkillName()).collect(Collectors.joining(","));
	}

	public EmployeeDto() {
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void seteEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public List<SkillDto> getSkillDtos() {
		return skillDtos;
	}

	public void setSkillDtos(List<SkillDto> skillDtos) {
		this.skillDtos = skillDtos;
		if (!Objects.isNull(skillDtos))
			this.skillsCsv = skillDtos.stream().map(e -> e.getSkillName()).collect(Collectors.joining(","));
	}

	public String getSkillsCsv() {
		return skillsCsv;
	}

	public void setSkillsCsv(String skillsCsv) {
		this.skillsCsv = skillsCsv;
	}

}
