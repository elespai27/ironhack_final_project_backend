package com.ironhack.Final.Project.repository;


import com.ironhack.Final.Project.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void givenUserName_whenFindByUserName_thenReturnUser() {
        User user = new User("tester", "test@email.com", "TopSecret");
        userRepository.save(user);

        Optional<User> found = userRepository.findByUserName("tester");

        assertTrue(found.isPresent());
        System.out.println(found.get());
        assertEquals("tester", found.get().getUserName());
    }


}