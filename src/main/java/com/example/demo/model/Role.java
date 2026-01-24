package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Role {
    
    @Id
    private Long id;

    @NotBlank(message = "The role name is required")
    private String roleName;

}
