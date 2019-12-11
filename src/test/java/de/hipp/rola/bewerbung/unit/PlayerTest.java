package de.hipp.rola.bewerbung.unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerTest {

    @Test
    void getGameOption() {
        Player player = new Player("Test Player");
        assertNotNull(player.getGameOption());
    }

    @Test
    void getWins() {
        Player player = new Player("Test Player");
        assertEquals(player.getWins(), 0);
        player.won();
        assertEquals(player.getWins(), 1);
    }

    @Test
    void getName() {
        String name = "Test Player";
        Player player = new Player(name);
        assertNotNull(player.getName());
        assertEquals(player.getName(), name);
    }

    @Test
    void testEquals() {
        String name = "Test Player";
        Player player1 = new Player(name);
        Player player2 = new Player(name);

        assertTrue(player1.equals(player2));

        Player player3 = new Player("Not the Test Player");
        assertFalse(player1.equals(player3));
    }
}