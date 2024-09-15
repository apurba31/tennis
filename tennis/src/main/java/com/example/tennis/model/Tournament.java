package com.example.tennis.model;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "tournament")
    private List<Matches> matches = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Matches> getMatches() {
        return matches;
    }

    public void setMatches(List<Matches> matches) {
        this.matches = matches;
    }
}
