package com.ironhack.Final.Project.controller.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedalBoardDTO {

    @NotEmpty(message = "Pedalboard name cannot be empty")
    private String pedalBoardName;
    private Long userId;


}
