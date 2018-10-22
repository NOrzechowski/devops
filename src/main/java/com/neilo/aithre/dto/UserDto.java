package com.neilo.aithre.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDto {
	Integer userId;
	String userName;
	List<SkillDto> skillDtos = new ArrayList<>();
	String skillsCsv;

	public UserDto(Integer userId, String userName, List<SkillDto> skillDtos) {
		this.userId = userId;
		this.userName = userName;
		this.skillDtos = skillDtos;
		if (!Objects.isNull(skillDtos))
			this.skillsCsv = skillDtos.stream().map(e -> e.getSkillName()).collect(Collectors.joining(","));
	}

	public UserDto() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
