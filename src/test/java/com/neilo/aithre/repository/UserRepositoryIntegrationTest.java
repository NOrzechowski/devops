package com.neilo.aithre.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.neilo.aithre.entity.Employee;
import com.neilo.aithre.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {
	@Autowired
    private TestEntityManager entityManager;
  
    @Autowired
    private EmployeeRepository userRepository;
 
    @Test
    public void testFindById() {
        Employee testEmployee = new Employee();
        testEmployee.setEmployeeName("neil orzechowski");
        entityManager.persist(testEmployee);
        entityManager.flush();     
        Optional<Employee> found = userRepository.findById(testEmployee.getEmployeeId());
        assertEquals(testEmployee.getEmployeeName(), found.get().getEmployeeName());
    }
    
 
}