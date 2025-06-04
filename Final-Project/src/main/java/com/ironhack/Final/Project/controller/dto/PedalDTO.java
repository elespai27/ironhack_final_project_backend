package com.ironhack.Final.Project.controller.dto;

import com.ironhack.Final.Project.model.PedalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedalDTO {
    private String pedalName;
    private PedalType pedalType;
    private Boolean pedalBypass;
    private String pedalParameters;
    private Long pedalBoardId;

}
