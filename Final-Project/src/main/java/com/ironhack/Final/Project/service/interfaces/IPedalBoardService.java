package com.ironhack.Final.Project.service.interfaces;

import com.ironhack.Final.Project.model.PedalBoard;

import java.util.List;

public interface IPedalBoardService {

    List<PedalBoard> getAllPedalboards();

    PedalBoard getPedalBoardById(Long pedalBoardId);

    PedalBoard createPedalBoard(PedalBoard pedalBoard);

    List<PedalBoard> getPedalboardsByUserId(Long userId);
}
