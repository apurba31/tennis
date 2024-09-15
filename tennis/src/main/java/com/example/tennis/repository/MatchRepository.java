package com.example.tennis.repository;

import com.example.tennis.model.Matches;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchRepository extends JpaRepository<Matches, Long> {
}
