package com.ironhack.Final.Project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedal {
    @Id
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

}