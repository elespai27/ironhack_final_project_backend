package com.ironhack.Final.Project.service.interfaces;

import com.ironhack.Final.Project.model.User;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public interface IUserService {
    User saveUser(User user);

    List<User> getAllUser();

    User updateUser(User user, String userName);

    User updateUserEmail(String email, Long userId);

    void deleteUser(Long userId);

    User getUserById(Long userId);
}
