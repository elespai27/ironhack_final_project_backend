package com.ironhack.Final.Project.service.impl;

import com.ironhack.Final.Project.model.Pedal;
import com.ironhack.Final.Project.model.PedalType;
import com.ironhack.Final.Project.repository.PedalBoardRepository;
import com.ironhack.Final.Project.repository.PedalRepository;
import com.ironhack.Final.Project.service.interfaces.IPedalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PedalService implements IPedalService {
    @Autowired
    private PedalRepository pedalRepository;

    @Autowired
    private PedalBoardRepository pedalBoardRepository;

    @Override
    public Pedal createPedal(Pedal pedal) {

        // Validate that the pedalboard exists and has ID
        if (pedal.getPedalBoard() == null || pedal.getPedalBoard().getPedalBoardId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PedalBoard must be specified and have a valid ID");
        }
        // Validate that there is no longer a pedal with the same name on the same pedalboard (optional but recommended)
        boolean exists = pedalRepository
                .findByPedalBoard_PedalBoardId(pedal.getPedalBoard().getPedalBoardId())
                .stream()
                .anyMatch(p -> p.getPedalName().equalsIgnoreCase(pedal.getPedalName()));

        if (exists) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "A pedal with that name already exists in this pedalboard");
        }

        return pedalRepository.save(pedal);
    }

    @Override
    public List<Pedal> getPedalsByPedalBoardId(Long pedalBoardId) {
        if (!pedalBoardRepository.existsById(pedalBoardId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "PedalBoard " + pedalBoardId + " not found.");
        }
        return pedalRepository.findByPedalBoard_PedalBoardId(pedalBoardId);
    }

    @Override
    public List<Pedal> getPedalsByPedalType(PedalType pedalType) {
        if (pedalType == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PedalType must be specified.");
        }
        return pedalRepository.findByPedalType(pedalType);
    }

}
