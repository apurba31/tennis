package com.example.tennis.controller;

import com.example.tennis.model.Matches;
import com.example.tennis.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/matches")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @PostMapping("/addMatch")
    public ResponseEntity<Matches> createMatch(@RequestBody Matches match) {
        Matches createdMatch = matchService.createMatch(match);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMatch);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matches> getMatchById(@PathVariable Long id) {
        Matches match = matchService.findMatchById(id);
        return ResponseEntity.ok(match);
    }

    @GetMapping
    public ResponseEntity<List<Matches>> getAllMatches() {
        List<Matches> matches = matchService.findAllMatches();
        return ResponseEntity.ok(matches);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matches> updateMatch(@PathVariable Long id, @RequestBody Matches match) {
        Matches updatedMatch = matchService.updateMatch(id, match);
        return ResponseEntity.ok(updatedMatch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}
