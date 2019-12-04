package de.hipp.rola.bewerbung.constants;

import java.util.Random;

public enum GameOption {
    PAPER(1),
    STONE(2),
    SCISSORS(3);

    private int id;

    private GameOption(int id, GameOption... winsagainst) {
        this.id = id;
    }

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
