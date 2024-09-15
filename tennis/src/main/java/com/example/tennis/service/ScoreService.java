package com.example.tennis.service;

import com.example.tennis.exception.ResourceNotFoundException;
import com.example.tennis.model.Score;
import com.example.tennis.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public Score createScore(Score score) {
        return scoreRepository.save(score);
    }

    public Score findScoreById(Long id) {
        return scoreRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Score not found with id " + id));
    }
    public List<Score> findAllScores() {
        return scoreRepository.findAll();
    }

    public Score updateScore(Long id, Score score) {
        Score existingScore = findScoreById(id);
        existingScore.setPlayer1Score(score.getPlayer1Score());
        existingScore.setPlayer2Score(score.getPlayer2Score());
        existingScore.setMatch(score.getMatch());
        return scoreRepository.save(existingScore);
    }

    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }
}
