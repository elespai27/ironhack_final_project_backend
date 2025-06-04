package com.ironhack.Final.Project.service.impl;

import com.ironhack.Final.Project.controller.dto.PedalDTO;
import com.ironhack.Final.Project.model.Pedal;
import com.ironhack.Final.Project.model.PedalBoard;
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
    public Pedal createPedal(PedalDTO dto) {
        PedalBoard pedalBoard = pedalBoardRepository.findById(dto.getPedalBoardId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedalboard not found"));
        Pedal pedal = new Pedal();
        pedal.setPedalName(dto.getPedalName());
        pedal.setPedalType(dto.getPedalType());
        pedal.setPedalBypass(dto.getPedalBypass());
        pedal.setPedalParameters(dto.getPedalParameters());
        pedal.setPedalBoard(pedalBoard);
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
