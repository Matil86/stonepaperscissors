package de.hipp.rola.bewerbung.constants;

import java.util.Random;

/**
 * Enum of possible GameOptions that someone could choose
 * <p>
 * Please not that if you add something here, that you also need to add a Rule in the RulesController
 */
public enum GameOption {
    PAPER(1),
    STONE(2),
    SCISSORS(3);

    private int id;

    private GameOption(int id) {
        this.id = id;
    }

    /**
     * Chooses randomly one of the Options
     *
     * @return a randomly chosen GameOption
     */
    public static GameOption getRandomOption() {
        int max = values().length - 1;
        int index = new Random().nextInt(max + 1);
        return values()[index];
    }

    public int getId() {
        return id;
    }

    public final boolean equals(GameOption other) {
        return this.getId() == other.getId();
    }
}
