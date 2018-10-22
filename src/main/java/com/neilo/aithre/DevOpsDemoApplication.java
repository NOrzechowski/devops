package com.neilo.aithre;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neilo.aithre.entity.Skill;
import com.neilo.aithre.entity.User;
import com.neilo.aithre.repository.UserRepository;

@SpringBootApplication
public class DevOpsDemoApplication {
	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DevOpsDemoApplication.class, args);
	}

	@PostConstruct
	public void setupDbWithData(){
		User user= new User("Neil Orzechowski", null);
		user.setSkills(Arrays.asList(new Skill("java"), new Skill("js")));
		user= userRepository.save(user);
	}
}
