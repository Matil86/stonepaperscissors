package unit;

import constants.Option;

public class Player {

    private Option option;
    private String name;
    private int wins = 0;

    public Player(String name) {
        this(name, null);
    }

    public Player(String name, Option option) {
        this.option = option;
        this.name = name;
    }

    public Option getOption() {
        return option == null ? Option.getRandomOption() : option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void addToWins(int win) {
        this.wins += win;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
