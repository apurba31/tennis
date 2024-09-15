package com.example.tennis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name="PLAYER")
public class Player {

    @Id
    @GeneratedValue
    private long id;
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
