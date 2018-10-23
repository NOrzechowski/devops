package com.neilo.aithre;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.neilo.aithre.entity.Skill;
import com.neilo.aithre.entity.Employee;
import com.neilo.aithre.repository.EmployeeRepository;

@SpringBootApplication
public class DevOpsDemoApplication {
	@Autowired
	EmployeeRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DevOpsDemoApplication.class, args);
	}

	@PostConstruct
	public void setupDbWithData(){
		Employee employee = new Employee("Neil Orzechowski", null);
		employee.setSkills(Arrays.asList(new Skill("java"), new Skill("js")));
		userRepository.save(employee);
	}
}
