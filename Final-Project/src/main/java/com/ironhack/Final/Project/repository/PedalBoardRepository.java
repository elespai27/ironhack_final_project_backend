package com.ironhack.Final.Project.repository;

import com.ironhack.Final.Project.model.PedalBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface PedalBoardRepository extends JpaRepository<PedalBoard, Long> {
//method with JPA Keyword
    Optional<PedalBoard> findByPedalBoardName(String pedalBoardName);
    List<PedalBoard> findByUser_UserId(Long userId);

}
