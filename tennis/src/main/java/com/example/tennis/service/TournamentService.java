package com.example.tennis.service;

import com.example.tennis.exception.ResourceNotFoundException;
import com.example.tennis.model.Tournament;
import com.example.tennis.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {
    @Autowired
    private TournamentRepository tournamentRepository;
    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public Tournament findTournamentById(Long id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tournament not found with id " + id));
    }
    public List<Tournament> findAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament updateTournament(Long id, Tournament tournament) {
        Tournament existingTournament = findTournamentById(id);
        existingTournament.setName(tournament.getName());
        return tournamentRepository.save(existingTournament);
    }

    public void deleteTournament(Long id) {
        tournamentRepository.deleteById(id);
    }
}
