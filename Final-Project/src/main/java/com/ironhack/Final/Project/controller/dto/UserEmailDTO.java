package com.ironhack.Final.Project.controller.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEmailDTO {

@NotEmpty(message = "Email cannot be empty")
    private String email;

}
