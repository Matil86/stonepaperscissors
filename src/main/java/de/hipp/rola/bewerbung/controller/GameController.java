package de.hipp.rola.bewerbung.controller;

import de.hipp.rola.bewerbung.constants.GameOption;
import de.hipp.rola.bewerbung.unit.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameController {

    int draw = 0;

    public void handlePlayers(List<Player> players, int gameRounds) {
        for (int i = 0; i < gameRounds; i++) {
            this.handlePlayers(players);
        }

        for (Player player : players) {
            System.out.println(player.getName() + " hat " + player.getWins() + " mal gewonnen");
        }
        System.out.println("Es gab " + draw + " unendschienden");
    }

    private void handlePlayers(final List<Player> players) {
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
                if (!playedAgainst.get(otherPlayer.getName()).contains(player.getName())) {
                    playedAgainst.get(otherPlayer.getName()).add(player.getName());
                    playedAgainst.get(player.getName()).add(otherPlayer.getName());
                }
            }
        }
    }

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

        switch (playerGameOption) {
            case PAPER:
                if (otherPlayerGameOption.equals(GameOption.STONE)) {
                    player.won();
                    break;
                }

                if (otherPlayerGameOption.equals(GameOption.SCISSORS)) {
                    otherPlayer.won();
                }
                break;
            case STONE:
                if (otherPlayerGameOption.equals(GameOption.SCISSORS)) {
                    player.won();
                    break;
                }

                if (otherPlayerGameOption.equals(GameOption.PAPER)) {
                    otherPlayer.won();
                }
                break;
            case SCISSORS:
                if (otherPlayerGameOption.equals(GameOption.PAPER)) {
                    player.won();
                    break;
                }

                if (otherPlayerGameOption.equals(GameOption.STONE)) {
                    otherPlayer.won();
                }
                break;
        }
    }
}
