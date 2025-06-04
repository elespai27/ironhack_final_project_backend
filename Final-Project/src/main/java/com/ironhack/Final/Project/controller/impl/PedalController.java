package com.ironhack.Final.Project.controller.impl;

import com.ironhack.Final.Project.controller.dto.PedalDTO;
import com.ironhack.Final.Project.model.Pedal;
import com.ironhack.Final.Project.model.PedalType;
import com.ironhack.Final.Project.service.interfaces.IPedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PedalController {
    @Autowired
    IPedalService pedalService;

    @PostMapping("/pedals")
    @ResponseStatus(HttpStatus.CREATED)
    public Pedal createPedal(@RequestBody PedalDTO pedalDTO) {
        return pedalService.createPedal(pedalDTO);
    }

    @GetMapping("/pedalboards/{pedalBoardId}/pedals")
    public List<Pedal> getPedalsByPedalBoardId(@PathVariable Long pedalBoardId) {
        return pedalService.getPedalsByPedalBoardId(pedalBoardId);
    }

    @GetMapping("/pedals/type/{type}")
    public List<Pedal> getPedalsByType(@PathVariable String type) {
        PedalType pedalType;
        try {
            pedalType = PedalType.fromString(type);
        } catch (IllegalArgumentException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid pedal type: " + type);
        }
        return pedalService.getPedalsByPedalType(pedalType);
    }

}
