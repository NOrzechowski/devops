package com.neilo.aithre.service;

import java.util.List;

import com.neilo.aithre.dto.UserDto;

public interface UserService {
    UserDto getUserById(Integer userId);
    void saveUser(UserDto userDto);
    List<UserDto> getAllUsers();
	List<UserDto> getAllUsersBySkillName(String skillName);
	List<UserDto> getAllUsersBySkillId(Integer skillId);
}
