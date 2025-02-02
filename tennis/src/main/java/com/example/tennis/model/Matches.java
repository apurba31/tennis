package com.example.tennis.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message="Date must not be empty")
    private String date;
    @NotNull(message = "Player 1 must not be null")
    @ManyToOne
    @JoinColumn(name = "player1_id")
    @Valid
    private Player player1;
    @NotNull(message = "Player 2 must not be null")
    @ManyToOne
    @JoinColumn(name = "player2_id")
    @Valid
    private Player player2;
    @NotNull(message = "Tournament id must not be empty")
    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
