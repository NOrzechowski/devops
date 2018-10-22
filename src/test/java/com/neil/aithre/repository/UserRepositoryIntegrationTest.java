package com.neil.aithre.repository;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.neilo.aithre.entity.User;
import com.neilo.aithre.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {
	@Autowired
    private TestEntityManager entityManager;
  
    @Autowired
    private UserRepository userRepository;
 
    @Test
    public void testFindById() {
        User testUser = new User();
        testUser.setUserName("neil orzechowski");
        entityManager.persist(testUser);
        entityManager.flush();
     
        Optional<User> found = userRepository.findById(testUser.getUserId());
     
        // then
        assertEquals(testUser.getUserName(), found.get().getUserName());
    }
 
}