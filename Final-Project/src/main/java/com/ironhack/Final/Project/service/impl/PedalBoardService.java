package com.ironhack.Final.Project.service.impl;

import com.ironhack.Final.Project.controller.dto.PedalBoardDTO;
import com.ironhack.Final.Project.model.PedalBoard;
import com.ironhack.Final.Project.model.User;
import com.ironhack.Final.Project.repository.PedalBoardRepository;
import com.ironhack.Final.Project.repository.UserRepository;
import com.ironhack.Final.Project.service.interfaces.IPedalBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PedalBoardService implements IPedalBoardService {
    @Autowired
    PedalBoardRepository pedalBoardRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public PedalBoard createPedalBoard(PedalBoardDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
        PedalBoard pedalBoard = new PedalBoard();
        pedalBoard.setPedalBoardName(dto.getPedalBoardName());
        pedalBoard.setUser(user);
        return pedalBoardRepository.save(pedalBoard);
        }


    @Override
    public List<PedalBoard> getAllPedalboards() {
        return pedalBoardRepository.findAll();
    }

    @Override
    public PedalBoard getPedalBoardById(Long pedalBoardId) {
        Optional<PedalBoard> pedalBoardOptional = pedalBoardRepository.findById(pedalBoardId);
        if(pedalBoardOptional.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND,  "PedalBoard " + pedalBoardId + " not found");
        return pedalBoardOptional.get();
    }

    @Override
    public List<PedalBoard> getPedalboardsByUserId(Long userId) {
        return pedalBoardRepository.findByUser_UserId(userId);
    }

}
