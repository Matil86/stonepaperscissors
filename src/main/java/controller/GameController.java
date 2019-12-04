package controller;

import constants.Option;
import unit.Player;

import java.util.List;

public class GameController {

    int draw = 0;

    public void handlePlayers(List<Player> players, int gameRounds) {
        for (int i = 0; i < gameRounds; i++) {
            this.handlePlayers(players);
        }

        for (Player player : players) {
            System.out.println(player.getName() + " hat " + player.getWins() + " mal gewonnen");
        }
        System.out.println("Es waren " + draw + " Unendschienden");
    }

    private void handlePlayers(final List<Player> players) {
        if (players == null || players.isEmpty()) {
            return;
        }

        for (Player player : players) {
            for (Player otherPlayer : players) {
                if (otherPlayer.equals(player)) {
                    continue;
                }
                this.playAgainst(player, otherPlayer);
            }
        }
    }

    private void playAgainst(final Player player, final Player otherPlayer) {
        if (player == null || otherPlayer == null) {
            return;
        }

        if (player.getOption().equals(otherPlayer.getOption())) {
            draw++;
            return;
        }

        Option playerOption = player.getOption();
        Option otherPlayerOption = otherPlayer.getOption();

        switch (playerOption) {
            case PAPER:
                if (otherPlayerOption.equals(Option.STONE)) {
                    player.addToWins(1);
                }

                if (otherPlayerOption.equals(Option.SCISSORS)) {
                    otherPlayer.addToWins(1);
                }
                break;
            case STONE:
                if (otherPlayerOption.equals(Option.SCISSORS)) {
                    player.addToWins(1);
                }

                if (otherPlayerOption.equals(Option.PAPER)) {
                    otherPlayer.addToWins(1);
                }
                break;
            case SCISSORS:
                if (otherPlayerOption.equals(Option.PAPER)) {
                    player.addToWins(1);
                }

                if (otherPlayerOption.equals(Option.STONE)) {
                    otherPlayer.addToWins(1);
                }
                break;
        }
    }
}
