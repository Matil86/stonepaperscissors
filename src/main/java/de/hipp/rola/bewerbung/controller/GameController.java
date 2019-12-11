package de.hipp.rola.bewerbung.controller;

import de.hipp.rola.bewerbung.constants.GameOption;
import de.hipp.rola.bewerbung.unit.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Logic Controller for the Game
 */
public class GameController {

    private int draw = 0;
    private RulesController rulesController = new RulesController();

    /**
     * Lets a List of Players play against each other
     * and prints out how often everybody won and how many draws there were
     *
     * @param players    List of Players that should play against each other
     * @param gameRounds number of Rounds they should play
     */
    public void handlePlayers(List<Player> players, int gameRounds) {
        for (int i = 0; i < gameRounds; i++) {
            this.handlePlayers(players);
        }

        for (Player player : players) {
            System.out.println(player.getName() + " hat " + player.getWins() + " mal gewonnen");
        }
        System.out.println("Es gab " + draw + " unendschienden");
    }

    /**
     * sub-Method that walks though the list of players
     *
     * @param players the list of players to walk through
     */
    void handlePlayers(final List<Player> players) {
        if (players == null || players.isEmpty()) {
            return;
        }

        Map<String, List<String>> playedAgainst = new HashMap<>();
        for (Player player : players) {
            for (Player otherPlayer : players) {

                if (!playedAgainst.containsKey(otherPlayer.getName())) {
                    playedAgainst.put(otherPlayer.getName(), new ArrayList<String>());
                }

                if (otherPlayer.equals(player)) {
                    continue;
                }

                if (playedAgainst.get(otherPlayer.getName()).contains(player.getName())) {
                    continue;
                }

                this.playAgainst(player, otherPlayer);

                // we need to remember who played against whom so they don't play twice in one Round
                if (!playedAgainst.get(otherPlayer.getName()).contains(player.getName())) {
                    playedAgainst.get(otherPlayer.getName()).add(player.getName());
                    playedAgainst.get(player.getName()).add(otherPlayer.getName());
                }
            }
        }
    }

    /**
     * compares the options both players chose and checks who wins
     *
     * @param player      Player 1 to check
     * @param otherPlayer Player 2 to check
     */
    private void playAgainst(final Player player, final Player otherPlayer) {
        if (player == null || otherPlayer == null) {
            return;
        }

        GameOption playerGameOption = player.getGameOption();
        GameOption otherPlayerGameOption = otherPlayer.getGameOption();

        if (playerGameOption.equals(otherPlayerGameOption)) {
            draw++;
            return;
        }

        if (rulesController.winsAgainst(playerGameOption, otherPlayerGameOption)) {
            player.won();
        } else {
            otherPlayer.won();
        }
    }
}
