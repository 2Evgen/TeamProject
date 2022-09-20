package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import com.sun.jdi.Value;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreIfSeveralGames() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Igra 1", "Arcade");
        Game game2 = store.publishGame("Igra 2", "Strategy");
        Game game3 = store.publishGame("Igra 3", "Arcade");
        Game game4 = store.publishGame("Igra 4", "Action");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);

        player.play(game1, 3);
        player.play(game2, 5);
        player.play(game3, 7);
        player.play(game4, 4);
        player.play(game3, 2);

        assertEquals(12, player.sumGenre("Arcade"));
    }

    @Test
    public void shouldPlayWhenGameNotInstalled() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");

        Assertions.assertThrows(RuntimeException.class, () -> {
            player.play(game,3);
        });
    }

    @Test
    public void shouldMostPlayerByGenre() {
        Player player = new Player("Petya");

        GameStore store = new GameStore();
        Game game1 = store.publishGame("Igra 1", "Arcade");
        Game game2 = store.publishGame("Igra 2", "Strategy");
        Game game3 = store.publishGame("Igra 3", "Arcade");

        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);

        player.play(game1, 2);
        player.play(game2, 5);
        player.play(game3, 4);

        Assertions.assertEquals(game3, player.mostPlayerByGenre("Arcade"));
    }

    @Test
    public void shouldMostPlayerByGenreWithoutGames() {
        Player player = new Player("Petya");
        assertNull(player.mostPlayerByGenre("Arcade"));
    }

    @Test
    public void shouldPlay() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Igra 1", "Arcade");
        Game game2 = store.publishGame("Igra 2", "Strategy");
        Game game3 = store.publishGame("Igra 3", "Arcade");
        Game game4 = store.publishGame("Igra 4", "Action");

        Player player = new Player("Petya");
        player.installGame(game1);
        player.installGame(game2);
        player.installGame(game3);
        player.installGame(game4);

        player.play(game1, 3);
        player.play(game2, 5);
        player.play(game3, 7);
        player.play(game4, 4);
        player.play(game3, 2);

        assertEquals(9, player.playedTime.get(game3));
    }
}
