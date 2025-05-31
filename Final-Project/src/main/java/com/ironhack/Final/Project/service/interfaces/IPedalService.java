package com.ironhack.Final.Project.service.interfaces;

import com.ironhack.Final.Project.model.Pedal;
import com.ironhack.Final.Project.model.PedalType;

import java.util.List;

public interface IPedalService {
    Pedal createPedal(Pedal pedal);

    List<Pedal> getPedalsByPedalBoardId(Long pedalBoardId);

    List<Pedal> getPedalsByPedalType(PedalType type);

}
