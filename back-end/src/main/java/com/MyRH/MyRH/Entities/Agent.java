package com.MyRH.MyRH.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(nullable=false, unique=true)
    private String email;

    @Column(nullable=false)
    private String password;

    // Getters and setters for each attribute
    // Constructor(s)
    // Other methods, if desired
}
