import constants.Option;
import controller.GameController;
import unit.Player;

import java.util.ArrayList;
import java.util.List;

public class starterClass {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<Player>();
        players.add(new Player("Spieler A", Option.PAPER));
        players.add(new Player("Spieler B"));
        int gameRounds = 100;
        new GameController().handlePlayers(players, gameRounds);
    }
}
