package com.example.tennis.service;

import com.example.tennis.model.Player;
import com.example.tennis.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player savePlayer(Player player){

        return playerRepository.save(player);
    }
    public List<Player> savePlayers(List<Player> player){

        return playerRepository.saveAll(player);
    }
    public List<Player> getPlayers(){

        return playerRepository.findAll();
    }
    public Player getPlayerById(long id){
        return playerRepository.findById(id).orElse(null);
    }
    public Player findByName(String name){
        return playerRepository.findByName(name);
    }
    public String deleteById(long id){
        playerRepository.deleteById(id);
        return "Player removed!" + id;
    }
    public Player updatePlayer(Player player){
        Player existingPlayer = playerRepository.findById(player.getId()).orElse(null);
        existingPlayer.setName(player.getName());
        return playerRepository.save(existingPlayer);
    }
}
