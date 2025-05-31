package com.ironhack.Final.Project.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PedalBoard {
    @Id
    private Long pedalBoardId;
    private String pedalBoardName;


    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonBackReference("user-pedalboards")
    @NotNull(message = "User cannot be null")
    private User user;

    @OneToMany(mappedBy = "pedalBoard",cascade = CascadeType.ALL)
    @JsonManagedReference("pedalboard-pedals")
    private List<Pedal> pedals = new ArrayList<>();

}
