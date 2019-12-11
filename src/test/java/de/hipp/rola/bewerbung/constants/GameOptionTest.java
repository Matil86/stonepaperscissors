package de.hipp.rola.bewerbung.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class GameOptionTest {

    @Test
    void getRandomOption() {
        assertNotNull(GameOption.getRandomOption());
        assertEquals(GameOption.getRandomOption().getClass(), GameOption.class);
    }

    @Test
    void isNotEmptyTest() {
        assertNotEquals(0, GameOption.values().length);
    }
}