package com.example.tennis.service;

import com.example.tennis.exception.ResourceNotFoundException;
import com.example.tennis.model.Matches;
import com.example.tennis.repository.MatchRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    Validator validator;

    public void validateMatch(Matches matches){
        Set<ConstraintViolation<Matches>> violations = validator.validate(matches);

        if (!violations.isEmpty()) {
            for (ConstraintViolation<Matches> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            throw new IllegalArgumentException("Validation errors occurred");
        }
    }

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
//        existingMatch.setDate(match.getDate());
//        existingMatch.setPlayer1(match.getPlayer1().getId());
//        existingMatch.setPlayer2(match.getPlayer2());
//        existingMatch.setTournament(match.getTournament());
//        return matchRepository.save(existingMatch);
        // Use getPlayer1().getId() if match.getPlayer1() is not null

        return matchRepository.save(existingMatch);
    }

    public void deleteMatch(Long id) {
        matchRepository.deleteById(id);
    }
}
