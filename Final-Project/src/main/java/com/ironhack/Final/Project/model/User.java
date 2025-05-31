package com.ironhack.Final.Project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor



public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long userId;
        private String userName;
        private String email;

        @NotBlank(message = "THe password cannot be blank")
        @Size(min = 5, max = 10, message = "The password must be between 5 and 8 characters")
        private String password;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference("user-pedalboards")
    private List<PedalBoard> pedalboards = new ArrayList<>();

    public User(String username, String email, String password) {
        this.userName = username;
        this.email = email;
        this.password = password;

    }
}
