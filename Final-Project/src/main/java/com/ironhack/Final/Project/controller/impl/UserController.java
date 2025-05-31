package com.ironhack.Final.Project.controller.impl;

import com.ironhack.Final.Project.controller.dto.UserEmailDTO;
import com.ironhack.Final.Project.model.User;
import com.ironhack.Final.Project.service.interfaces.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    IUserService userService;

//Create
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }
//Read
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/user/{userId}")
    public User getUserWithPedalboards(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

//Update
    @PutMapping("/users/{userName}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User updateUser(@RequestBody @Valid User user, @PathVariable String userName) {
        return userService.updateUser(user, userName);
    }
//Update part of
    @PatchMapping("/users/email/{userId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User updateUserEmail(@RequestBody @Valid UserEmailDTO userEmailDTO, @PathVariable Long userId) {
        return userService.updateUserEmail(userEmailDTO.getEmail(), userId);
    }
//Delete
    @DeleteMapping("/users/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);

    }

}
