package com.ironhack.Final.Project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Pedal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedalId;

    private String pedalName;

    @Enumerated(EnumType.STRING)
    private PedalType pedalType;
    private Boolean pedalBypass;

    @Column(columnDefinition = "json")
    private String pedalParameters;

    @ManyToOne
    @JoinColumn(name = "pedalBoardId")
    @JsonBackReference("pedalboard-pedals")
    private PedalBoard pedalBoard;

    public Pedal(String pedalName, PedalType pedalType, Boolean pedalBypass, String pedalParameters, PedalBoard pedalBoard) {
        this.pedalName = pedalName;
        this.pedalType = pedalType;
        this.pedalBypass = pedalBypass;
        this.pedalParameters = pedalParameters;
        this.pedalBoard = pedalBoard;
    }
}