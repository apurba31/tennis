package com.example.tennis.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void testPlayerConstructor() {
        // Arrange
        long id = 1L;
        String name = "John Doe";

        // Act
        Player player = new Player(id, name);

        // Assert
        assertEquals(id, player.getId());
        assertEquals(name, player.getName());
    }

    @Test
    public void testGettersAndSetters() {
        // Arrange
        Player player = new Player(1L, "John Doe");

        // Act
        player.setId(2L);
        player.setName("Roger Federer");

        // Assert
        assertEquals(2L, player.getId());
        assertEquals("Roger Federer", player.getName());
    }
    @Test
    public void testDefaultConstructor() {
        // Act
        Player player = new Player();

        // Assert
        assertNotNull(player); // Check if the player instance is created
    }

}