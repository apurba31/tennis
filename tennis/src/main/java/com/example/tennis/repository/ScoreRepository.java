package com.example.tennis.repository;

import com.example.tennis.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, Long> {
}
