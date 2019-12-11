package de.hipp.rola.bewerbung.controller;

import de.hipp.rola.bewerbung.constants.GameOption;
import de.hipp.rola.bewerbung.unit.Player;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameControllerTest {

    static List<Player> players = new ArrayList<>();

    @BeforeAll
    static void setup() {
        players.add(new Player("Stone Player", GameOption.STONE));
        players.add(new Player("Paper Player", GameOption.PAPER));
        players.add(new Player("Scissors Player", GameOption.SCISSORS));
    }

    @Test
    void handlePlayersTest() {
        GameController gameController = new GameController();
        gameController.handlePlayers(players);

        players.forEach(player -> {
            assertEquals(player.getWins(), 1);
        });

    }
}