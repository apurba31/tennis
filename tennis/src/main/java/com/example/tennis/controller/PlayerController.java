package com.example.tennis.controller;

import com.example.tennis.model.Player;
import com.example.tennis.service.PlayerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/players")
public class PlayerController {
    private static final Logger logger = LoggerFactory.getLogger(PlayerService.class);
    @Autowired
    private PlayerService playerService;
    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player player){
        logger.info("Player added");
        return playerService.savePlayer(player);
    }
    @PostMapping("/addPlayers")
    public List<Player> addPlayers(@RequestBody List<Player> players){
        logger.info("Players added");
        return playerService.savePlayers(players);
    }
    @GetMapping("/players")
    public List<Player> findAllPlayers(){
        logger.info("All players are listed");
        return playerService.getPlayers();
    }
    @GetMapping("/player/id/{id}")
    public Player findPlayerById(@PathVariable long id){

        return playerService.getPlayerById(id);
    }
    @GetMapping("/player/name/{name}")
    public Player findPlayerByName(@PathVariable String name){

        return playerService.findByName(name);
    }
    @PutMapping("/update")
    public Player updatePlayer(@RequestBody Player player){

        return playerService.updatePlayer(player);
    }
    @DeleteMapping("/delete/{id}")
    public String deletePlayer(@PathVariable long id){

        return playerService.deleteById(id);
    }

}
