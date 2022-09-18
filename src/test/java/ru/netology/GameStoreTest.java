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

        Assertions.assertEquals("Igrok 2", store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerWithoutPlayers() {
        Assertions.assertNull(store.getMostPlayer());
    }
}
