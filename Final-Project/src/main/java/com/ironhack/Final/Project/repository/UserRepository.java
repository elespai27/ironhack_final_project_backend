package com.ironhack.Final.Project.repository;


import com.ironhack.Final.Project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    //method with JPA Keyword

Optional<User> findByUserName(String userName);


}
