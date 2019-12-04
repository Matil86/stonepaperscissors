package de.hipp.rola.bewerbung.unit;

import de.hipp.rola.bewerbung.constants.GameOption;

public class Player {

    private GameOption gameOption;
    private String name;
    private int wins = 0;

    public Player(String name) {
        this(name, null);
    }

    public Player(String name, GameOption gameOption) {
        this.gameOption = gameOption;
        this.name = name;
    }

    public GameOption getGameOption() {
        return gameOption == null ? GameOption.getRandomOption() : gameOption;
    }

    public void setGameOption(GameOption gameOption) {
        this.gameOption = gameOption;
    }

    public int getWins() {
        return wins;
    }

    public void won() {
        this.wins += 1;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Player other) {
        return this.getName().equals(other.getName());
    }
}
