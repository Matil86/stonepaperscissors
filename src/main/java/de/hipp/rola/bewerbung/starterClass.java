package de.hipp.rola.bewerbung;

import de.hipp.rola.bewerbung.constants.GameOption;
import de.hipp.rola.bewerbung.controller.GameController;
import de.hipp.rola.bewerbung.unit.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Task for the Job Interview for Rola Security Systems GmbH in Oberhausen
 */
public class starterClass {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Spieler A", GameOption.PAPER));
        players.add(new Player("Spieler B"));
        int gameRounds = 100;
        new GameController().handlePlayers(players, gameRounds);
    }
}
