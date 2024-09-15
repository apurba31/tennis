package com.example.tennis.controller;

import com.example.tennis.model.Player;
import com.example.tennis.service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PlayerControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private PlayerService playerService;

    @InjectMocks
    private PlayerController playerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(playerController).build();
    }
    @Test
    public void testAddPlayer() throws Exception {
        Player player = new Player();
        player.setName("Roger Federer");
        when(playerService.savePlayer(player)).thenReturn(player);
        mockMvc.perform(post("/api/v1/players/addPlayer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(player)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Roger Federer"));

        verify(playerService, times(1)).savePlayer(any(Player.class));
    }
    @Test
    public void testAddPlayers() throws Exception {
        Player player1 = new Player();
        player1.setName("Roger Federer");
        Player player2 = new Player();
        player2.setName("Rafael Nadal");
        List<Player> players = Arrays.asList(player1, player2);

        when(playerService.savePlayers(players)).thenReturn(players);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/players/addPlayers")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(players)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Roger Federer"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Rafael Nadal"));
    }
    @Test
    public void testFindAllPlayers() throws Exception {
        Player player1 = new Player();
        player1.setName("Roger Federer");
        Player player2 = new Player();
        player2.setName("Rafael Nadal");
        List<Player> players = Arrays.asList(player1, player2);

        when(playerService.getPlayers()).thenReturn(players);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/players/players"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Roger Federer"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value("Rafael Nadal"));
    }

    @Test
    public void testFindPlayerById() throws Exception {
        Player player = new Player();
        player.setName("Roger Federer");
        long id = 1L;

        when(playerService.getPlayerById(id)).thenReturn(player);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/players/player/id/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Roger Federer"));
    }

    @Test
    public void testFindPlayerByName() throws Exception {
        Player player = new Player();
        player.setName("Roger Federer");
        String name = "Roger Federer";

        when(playerService.findByName(name)).thenReturn(player);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/players/player/name/{name}", name))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Roger Federer"));
    }

    @Test
    public void testUpdatePlayer() throws Exception {
        Player player = new Player();
        player.setName("Roger Federer");

        when(playerService.updatePlayer(player)).thenReturn(player);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/players/update")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(player)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Roger Federer"));
    }

    @Test
    public void testDeletePlayer() throws Exception {
        long id = 1L;
        String responseMessage = "Player deleted successfully";

        when(playerService.deleteById(id)).thenReturn(responseMessage);

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/players/delete/{id}", id))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(responseMessage));
    }

}