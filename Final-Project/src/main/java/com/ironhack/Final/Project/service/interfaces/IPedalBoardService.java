package com.ironhack.Final.Project.service.interfaces;

import com.ironhack.Final.Project.controller.dto.PedalBoardDTO;
import com.ironhack.Final.Project.model.PedalBoard;

import java.util.List;

public interface IPedalBoardService {

    List<PedalBoard> getAllPedalboards();

    PedalBoard getPedalBoardById(Long pedalBoardId);

    PedalBoard createPedalBoard(PedalBoardDTO pedalBoardDTO);

    List<PedalBoard> getPedalboardsByUserId(Long userId);
}
