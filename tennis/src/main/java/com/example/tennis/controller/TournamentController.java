package com.example.tennis.controller;

import com.example.tennis.model.Tournament;
import com.example.tennis.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tournaments")
public class TournamentController {
    @Autowired
    private TournamentService tournamentService;

    @PostMapping("/addTournament")
    public ResponseEntity<Tournament> createTournament(@RequestBody Tournament tournament) {
        Tournament createdTournament = tournamentService.createTournament(tournament);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTournament);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tournament> getTournamentById(@PathVariable Long id) {
        Tournament tournament = tournamentService.findTournamentById(id);
        return ResponseEntity.ok(tournament);
    }

    @GetMapping
    public ResponseEntity<List<Tournament>> getAllTournaments() {
        List<Tournament> tournaments = tournamentService.findAllTournaments();
        return ResponseEntity.ok(tournaments);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tournament> updateTournament(@PathVariable Long id, @RequestBody Tournament tournament) {
        Tournament updatedTournament = tournamentService.updateTournament(id, tournament);
        return ResponseEntity.ok(updatedTournament);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable Long id) {
        tournamentService.deleteTournament(id);
        return ResponseEntity.noContent().build();
    }
}
