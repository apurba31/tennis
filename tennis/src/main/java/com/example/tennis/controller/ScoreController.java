package com.example.tennis.controller;

import com.example.tennis.model.Score;
import com.example.tennis.service.ScoreService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/scores")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @PostMapping("/addScore")
    public ResponseEntity<Score> createScore(@RequestBody Score score) {
        Score createdScore = scoreService.createScore(score);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdScore);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Score> getScoreById(@PathVariable Long id) {
        Score score = scoreService.findScoreById(id);
        return ResponseEntity.ok(score);
    }

    @GetMapping
    public ResponseEntity<List<Score>> getAllScores() {
        List<Score> scores = scoreService.findAllScores();
        return ResponseEntity.ok(scores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Score> updateScore(@PathVariable Long id, @RequestBody Score score) {
        Score updatedScore = scoreService.updateScore(id, score);
        return ResponseEntity.ok(updatedScore);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScore(@PathVariable Long id) {
        scoreService.deleteScore(id);
        return ResponseEntity.noContent().build();
    }
}
