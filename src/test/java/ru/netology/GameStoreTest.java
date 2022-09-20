package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    // другие ваши тесты

    @Test
    public void shouldReturnFalseAddGames() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = new Game("Ищейка", "Стратегия", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldReturnFalseContainsGame() {

        GameStore store = new GameStore();

        Game game2 = new Game("Ищейка", "Стратегия", store);

        assertFalse(store.containsGame(game2));
    }

    @Test
    public void shouldGetMostPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("A", 3);
        store.addPlayTime("B", 9);
        store.addPlayTime("C", 6);

        String[] expected = {"B"};
        Assertions.assertArrayEquals(expected, store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerEqualsZero() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("A", 0);

        String expected = null;
        assertEquals(expected, store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerReturnNull() {

        GameStore store = new GameStore();

        assertNull(store.getMostPlayer());
    }

    @Test
    public void shouldReturnNullGetMostPlayerNegativeValue() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        store.addPlayTime("A", -1);

        assertNull(store.getMostPlayer());
    }

    @Test
    public void shouldRegisteredAddPlayTime() {

        GameStore store = new GameStore();

        store.addPlayTime("A", 0);
        store.addPlayTime("A", 2);

        String[] expected = {"A"};
        Assertions.assertArrayEquals(expected, store.getMostPlayer());
    }

    @Test
    public void shouldGetMostPlayerEquallyOne() {

        GameStore store = new GameStore();

        store.addPlayTime("A", 1);

        String[] expected = {"A"};
        Assertions.assertArrayEquals(expected, store.getMostPlayer());
    }

    @Test
    public void shouldGetSumPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("A", 1);
        store.addPlayTime("B", 4);
        store.addPlayTime("C", 2);

        int actual = store.getSumPlayedTime();
        int expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroGetSumPlayedTime() {

        GameStore store = new GameStore();

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetSumZeroPlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("A", 0);
        store.addPlayTime("Br", 0);
        store.addPlayTime("C", 0);

        int actual = store.getSumPlayedTime();
        int expected = 0;
        assertEquals(expected, actual);

    }

    @Test
    public void shouldGetSumOnePlayedTime() {

        GameStore store = new GameStore();

        store.addPlayTime("A", 0);
        store.addPlayTime("B", 1);
        store.addPlayTime("C", 0);

        int actual = store.getSumPlayedTime();
        int expected = 1;
        assertEquals(expected, actual);

    }
}