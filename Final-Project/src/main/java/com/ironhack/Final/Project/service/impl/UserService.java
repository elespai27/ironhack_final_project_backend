package com.ironhack.Final.Project.service.impl;

import com.ironhack.Final.Project.model.Pedal;
import com.ironhack.Final.Project.model.PedalBoard;
import com.ironhack.Final.Project.model.User;
import com.ironhack.Final.Project.repository.PedalBoardRepository;
import com.ironhack.Final.Project.repository.PedalRepository;
import com.ironhack.Final.Project.repository.UserRepository;
import com.ironhack.Final.Project.service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PedalBoardRepository pedalBoardRepository;

    @Autowired
    PedalRepository pedalRepository;




    @Override
    public User saveUser(User user) {
        if (userRepository.findByUserName(user.getUserName()).isPresent()){
            throw new IllegalArgumentException("The User's name already exists");
        }
        if (user.getPedalboards() != null) {
            for (PedalBoard pedalBoard : user.getPedalboards()) {
                if (pedalBoardRepository.existsById(pedalBoard.getPedalBoardId())) {
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "PedalBoard ID " + pedalBoard.getPedalBoardId() + " already exists.");
                }
                pedalBoard.setUser(user);
                if (pedalBoard.getPedals() != null) {
                    for (Pedal pedal : pedalBoard.getPedals()) {
                        if (pedalRepository.existsById(pedal.getPedalId())) {
                            throw new ResponseStatusException(HttpStatus.CONFLICT, "Pedal ID " + pedal.getPedalId() + " already exists.");
                        }
                        pedal.setPedalBoard(pedalBoard);
                    }
                }
            }
        }
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User" + userId + " not found.");
        return userOptional.get();

    }

    @Override
    public User updateUser(User user, String userName) {
        Optional<User> userOptional = userRepository.findByUserName(userName);
        if (userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User " + userName + " not found");
        User existingUser = userOptional.get();
        existingUser.setEmail(user.getEmail());
        existingUser.setPassword(user.getPassword());
        existingUser.setUserName(user.getUserName());

        return userRepository.save(existingUser);
    }

    @Override
    public User updateUserEmail(String email, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User" + userId + " not found.");

        User existingUser = userOptional.get();
        existingUser.setEmail(email);
         return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User" + userId + " not found.");
        userRepository.deleteById((userId));
    }


}
