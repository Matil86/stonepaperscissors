package de.hipp.rola.bewerbung.unit;

import de.hipp.rola.bewerbung.constants.GameOption;

/**
 * Player Class that holds basic Information of the participating Player
 */
public class Player {

    private GameOption gameOption;
    private String name;
    private int wins = 0;

    /**
     * Initializes a Player with just a Name
     *
     * @param name Name of the Player
     */
    public Player(String name) {
        this(name, null);
    }

    /**
     * Initializes a Player with a certain Name and a specific GameOption that Player chose
     *
     * @param name       Name of the Player
     * @param gameOption GameOption the Player chose
     */
    public Player(String name, GameOption gameOption) {
        this.gameOption = gameOption;
        this.name = name;
    }

    /**
     * Return the either chosen GameOption or a Random one
     *
     * @return a GameOption for the Player
     */
    public GameOption getGameOption() {
        return gameOption == null ? GameOption.getRandomOption() : gameOption;
    }

    /**
     * Getter for the Number of Wins
     *
     * @return {Int} of the Number of Wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Increases the Wins by 1
     */
    public void won() {
        this.wins += 1;
    }

    /**
     * Getter for the Name Variable
     *
     * @return {String} the Name of the Player
     */
    public String getName() {
        return name;
    }

    /**
     * compares the Player with another one by Name
     *
     * @param other the other Player to compare
     * @return {boolean} if they are equal or not
     */
    public boolean equals(Player other) {
        return this.getName().equals(other.getName());
    }
}
