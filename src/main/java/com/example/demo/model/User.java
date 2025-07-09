package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "The first name is required")
    @Column
    private String firstName;

    @NotBlank(message = "The last name is required")
    @Column
    private String lastName;

    @NotBlank(message = "The username is required")
    @Column
    private String username;

    @NotBlank(message = "The password is required")
    @Column
    private String password;

}
