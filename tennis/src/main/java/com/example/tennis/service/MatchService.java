package com.example.tennis.service;

import com.example.tennis.exception.ResourceNotFoundException;
import com.example.tennis.model.Matches;
import com.example.tennis.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;

    public Matches createMatch(Matches match) {
        return matchRepository.save(match);
    }

    public Matches findMatchById(Long id) {
        return matchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Match not found with id " + id));
    }
    public List<Matches> findAllMatches() {
        return matchRepository.findAll();
    }

    public Matches updateMatch(Long id, Matches match) {
        Matches existingMatch = findMatchById(id);
        existingMatch.setDate(match.getDate());
        existingMatch.setPlayer1(match.getPlayer1());
        existingMatch.setPlayer2(match.getPlayer2());
        existingMatch.setTournament(match.getTournament());
        return matchRepository.save(existingMatch);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
