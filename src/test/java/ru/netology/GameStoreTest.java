package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class GameStoreTest {
    GameStore store = new GameStore();

    @Test
    public void shouldAddGame() {

        Game game = store.publishGame("Igra 1", "Arcade");
        assertTrue(store.containsGame(game));
    }

    @Test
    public void shouldGetSumPlayedTime() {

        store.addPlayTime("Igrok 1", 2);
        store.addPlayTime("Igrok 2", 3);
        store.addPlayTime("Igrok 3", 18);
        store.addPlayTime("Igrok 2", 4);

        Assertions.assertEquals(27, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetSumPlayedTimeIfOneGamer() {

        store.addPlayTime("Igrok 1", 2);
        store.addPlayTime("Igrok 1", 3);
        store.addPlayTime("Igrok 1", 18);
        store.addPlayTime("Igrok 1", 4);

        Assertions.assertEquals(27, store.getSumPlayedTime());
    }

    @Test
    public void shouldGetMostPlayer() {

        store.addPlayTime("Igrok 1", 2);
        store.addPlayTime("Igrok 2", 3);
        store.addPlayTime("Igrok 3", 7);
        store.addPlayTime("Igrok 2", 5);

        String[] expected = {"Igrok 2"};

        Assertions.assertArrayEquals(expected, store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerIfSameTimeForDifferentPlayers() {

        store.addPlayTime("Igrok 1", 2);
        store.addPlayTime("Igrok 2", 3);
        store.addPlayTime("Igrok 3", 7);
        store.addPlayTime("Igrok 2", 5);
        store.addPlayTime("Igrok 4", 8);

        String[] expected = {"Igrok 4", "Igrok 2"};

        Assertions.assertArrayEquals(expected, store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerWithoutPlayers() {
        Assertions.assertNull(store.getMostPlayer());
    }
}
