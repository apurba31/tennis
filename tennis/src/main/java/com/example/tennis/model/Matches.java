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
//    @ManyToOne(fetch = FetchType.LAZY)  // Use LAZY fetching to avoid unnecessary loading
//    @JoinColumn(name = "player1_id", nullable = false)  // Ensure it's NOT NULL in DB
    @Column(name = "player1_id")
    @Valid
    private Long player1;
    @NotNull(message = "Player 2 must not be null")
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "player2_id", nullable = false)
    @Valid
    @Column(name = "player2_id")
    private Long player2;
    @NotNull(message = "Tournament id must not be empty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournament_id", nullable = false)
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

    public Long getPlayer1() {
        return player1;
    }

    public Long getPlayer2() {
        return player2;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
