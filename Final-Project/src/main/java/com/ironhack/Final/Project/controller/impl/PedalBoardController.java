package com.ironhack.Final.Project.controller.impl;

import com.ironhack.Final.Project.model.PedalBoard;
import com.ironhack.Final.Project.service.interfaces.IPedalBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PedalBoardController {

    @Autowired
    IPedalBoardService pedalBoardService;

//Create
@PostMapping("/pedalboards")
@ResponseStatus(HttpStatus.CREATED)
public PedalBoard createPedalBoard(@RequestBody PedalBoard pedalBoard) {
    return pedalBoardService.createPedalBoard(pedalBoard);
}


//Read
    @GetMapping("/pedalboards")
    public List<PedalBoard> getAllPedalboards() {
        return pedalBoardService.getAllPedalboards();
    }

    @GetMapping("/pedalboards/{pedalBoardId}")
    public PedalBoard getPedalBoardById(@PathVariable Long pedalBoardId) {
        return pedalBoardService.getPedalBoardById(pedalBoardId);
    }

    @GetMapping("/users/{userId}/pedalboards")
    public List<PedalBoard> getPedalboardsByUserId(@PathVariable Long userId) {
        return pedalBoardService.getPedalboardsByUserId(userId);
    }

}
