package com.example.tennis.service;

import com.example.tennis.model.Player;
import com.example.tennis.repository.PlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerServiceTest {
    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    private Player player1;
    private Player player2;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        player1 = new Player(1L, "Roger Federer");
        player2 = new Player(2L, "Rafael Nadal");
    }
    @Test
    void testSavePlayer(){
        when(playerRepository.save(player1)).thenReturn(player1);
        Player savePlayer = playerService.savePlayer(player1);
        assertNotNull(savePlayer);
        assertEquals("Roger Federer", savePlayer.getName());
    }
    @Test
    void savePlayers() {
        List<Player> players = Arrays.asList(player1, player2);
        when(playerRepository.saveAll(players)).thenReturn(players);
        List<Player> savedPlayers = playerService.savePlayers(players);
        assertEquals(2, savedPlayers.size());
    }

    @Test
    void getPlayers() {
        List<Player> players = Arrays.asList(player1, player2);
        when(playerRepository.findAll()).thenReturn(players);
        List<Player> foundPlayers = playerService.getPlayers();
        assertEquals(2, foundPlayers.size());
    }

    @Test
    void getPlayerById() {
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player1));
        Player foundPlayer = playerService.getPlayerById(1L);
        assertNotNull(foundPlayer);
        assertEquals("Roger Federer", foundPlayer.getName());
    }

    @Test
    void findByName() {
        when(playerRepository.findByName("Roger Federer")).thenReturn(player1);
        Player foundPlayer = playerService.findByName("Roger Federer");
        assertNotNull(foundPlayer);
        assertEquals("Roger Federer", foundPlayer.getName());
    }

    @Test
    void deleteById() {
        doNothing().when(playerRepository).deleteById(1L);
        String result = playerService.deleteById(1L);
        assertEquals("Player removed!1", result);
        verify(playerRepository, times(1)).deleteById(1L);
    }

    @Test
    void updatePlayer() {
        when(playerRepository.findById(1L)).thenReturn(Optional.of(player1));
        when(playerRepository.save(player1)).thenReturn(player1);

        player1.setName("New Name");
        Player updatedPlayer = playerService.updatePlayer(player1);

        assertNotNull(updatedPlayer);
        assertEquals("New Name", updatedPlayer.getName());
        verify(playerRepository, times(1)).save(player1);
    }

}