package de.hipp.rola.bewerbung.controller;

import de.hipp.rola.bewerbung.constants.GameOption;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RulesControllerTest {

    private static RulesController rulesController;

    @BeforeAll
    static void setup() {
        rulesController = new RulesController();
    }

    @Test
    void baseControllerTest() {
        assertFalse(rulesController.getWinsAgainstMapping().isEmpty());
    }

    @Test
    void PaperRulesTest() {
        assertTrue(rulesController.winsAgainst(GameOption.PAPER, GameOption.STONE));
        assertFalse(rulesController.winsAgainst(GameOption.PAPER, GameOption.SCISSORS));
        assertFalse(rulesController.winsAgainst(GameOption.PAPER, GameOption.PAPER));
    }

    @Test
    void StoneRulesTest() {
        assertTrue(rulesController.winsAgainst(GameOption.STONE, GameOption.SCISSORS));
        assertFalse(rulesController.winsAgainst(GameOption.STONE, GameOption.PAPER));
        assertFalse(rulesController.winsAgainst(GameOption.STONE, GameOption.STONE));
    }

    @Test
    void ScissorsRuleTest() {
        assertTrue(rulesController.winsAgainst(GameOption.SCISSORS, GameOption.PAPER));
        assertFalse(rulesController.winsAgainst(GameOption.SCISSORS, GameOption.STONE));
        assertFalse(rulesController.winsAgainst(GameOption.SCISSORS, GameOption.SCISSORS));
    }
}