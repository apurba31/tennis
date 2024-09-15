package com.example.tennis.repository;

import com.example.tennis.model.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
