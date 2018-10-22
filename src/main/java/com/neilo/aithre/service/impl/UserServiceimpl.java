package com.neilo.aithre.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neilo.aithre.converter.UserConverter;
import com.neilo.aithre.dto.UserDto;
import com.neilo.aithre.entity.User;
import com.neilo.aithre.repository.UserRepository;
import com.neilo.aithre.service.UserService;


@Service
public class UserServiceimpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDto getUserById(Integer userId) {
		return UserConverter.entityToDto(userRepository.getOne(userId));
	}

	@Override
	public void saveUser(UserDto userDto) {
		userRepository.save(UserConverter.dtoToEntity(userDto));
	}

	@Override
	public List<UserDto> getAllUsers() {
		return userRepository.findAll().stream().map(UserConverter::entityToDto).collect(Collectors.toList());
	}
	
	@Override
	public List<UserDto> getAllUsersBySkillName(String skillName) {	
		List<UserDto> users = new ArrayList<UserDto>();
		for(User user :  userRepository.findAll()) {
			 boolean exists = user.getSkills().stream()
			            .anyMatch(t -> t.getSkillName().equals(skillName));
			 if(exists) {
				 users.add(UserConverter.entityToDto(user));
			 }
		}
		return users;
	}
	
	@Override
	public List<UserDto> getAllUsersBySkillId(Integer skillId) {	
		List<UserDto> users = new ArrayList<UserDto>();
		for(User user :  userRepository.findAll()) {
			 boolean exists = user.getSkills().stream()
			            .anyMatch(t -> t.getSkillId().equals(skillId));
			 if(exists) {
				 users.add(UserConverter.entityToDto(user));
			 }
		}
		return users;
	}
}
