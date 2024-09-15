package com.example.tennis.model;

import jakarta.persistence.*;

@Entity
public class Matches {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    @ManyToOne
    @JoinColumn(name = "player1_id")
    private Player player1;

    @ManyToOne
    @JoinColumn(name = "player2_id")
    private Player player2;

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
