package com.example.tennis.model;

import jakarta.persistence.*;

@Entity
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int player1Score;
    private int player2Score;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPlayer1Score() {
        return player1Score;
    }

    public void setPlayer1Score(int player1Score) {
        this.player1Score = player1Score;
    }

    public int getPlayer2Score() {
        return player2Score;
    }

    public void setPlayer2Score(int player2Score) {
        this.player2Score = player2Score;
    }

    public Matches getMatch() {
        return match;
    }

    public void setMatch(Matches match) {
        this.match = match;
    }

    @OneToOne
    @JoinColumn(name = "match_id")
    private Matches match;

}
