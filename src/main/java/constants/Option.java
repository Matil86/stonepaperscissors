package constants;

import java.util.Random;

public enum Option {
    PAPER(1),
    STONE(2),
    SCISSORS(3);

    private int id;

    private Option(int id) {
        this.id = id;
    }

    public static Option getRandomOption() {
        int max = values().length - 1;
        int index = new Random().nextInt(max + 1);
        return values()[index];
    }
}
