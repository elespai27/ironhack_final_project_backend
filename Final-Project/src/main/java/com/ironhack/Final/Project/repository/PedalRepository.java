package com.ironhack.Final.Project.repository;

import com.ironhack.Final.Project.model.Pedal;
import com.ironhack.Final.Project.model.PedalType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedalRepository extends JpaRepository<Pedal, Long> {
    //method with JPA Keyword
    List<Pedal> findByPedalType(PedalType pedalType);

    List<Pedal> findByPedalBoard_PedalBoardId(Long pedalBoardId);

}
