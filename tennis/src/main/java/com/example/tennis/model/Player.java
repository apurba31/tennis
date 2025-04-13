package com.example.tennis.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
@Entity
@Table(name="PLAYER")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "Player name must not be empty")
    private String name;

    public Player(long l, String johnDoe, int i) {
    }
    // Default constructor for JPA
    public Player() {
    }

    // Parameterized constructor
    public Player(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
