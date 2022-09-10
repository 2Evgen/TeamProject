
package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import java.util.List;


public class GameStoreTest {
    @Nested
    @DisplayName("Тесты на список игр")
    public class GameListTest {
        GameStore storeEmpty = new GameStore();
        GameStore storeOneGame = new GameStore();
        GameStore storeSomeGames = new GameStore();

        @BeforeEach
        public void setup() {
            storeOneGame.publishGame("Witcher 3", "Action");
            storeSomeGames.publishGame("Witcher 3", "Action");
            storeSomeGames.publishGame("The Elder Scrolls V: Skyrim", "Action");
            storeSomeGames.publishGame("Kerbal Space Program", "Sandbox");
            storeSomeGames.publishGame("Europe Universalis IV", "Strategy");
            storeSomeGames.publishGame("XCOM 2", "Tactic");
        }
    }

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Disabled("Невозможно получить actual")
    @Nested
    @DisplayName("Тестирование метода publishGame()")
    public class publishGameTests {
        //TODO для тестабилити return в метод publishGame или геттер на games
        @Nested
        @DisplayName("Пустой магазин")
        public class EmptyStore {
            @Test
            public void shouldPublishGame() {
                List<Game> expected = new ArrayList<>();
                GameStore storeEmpty = null;
                expected.add(new Game("Witcher 3", "Action", null));
                //assertTrue(expected.equals(storeEmpty.publishGame("Witcher 3", "Action")));
            }
        }

        @Nested
        @DisplayName("Магазин с одной игрой")
        public class StoreWithOneGame {
            @Test
            public void shouldPublishNewGame() {
                List<Game> expected = new ArrayList<>();
                GameStore storeOneGame = new GameStore();
                expected.add(new Game("Witcher 3", "Action", storeOneGame));
                expected.add(new Game("Kerbal Space Program", "Sandbox", storeOneGame));
                //assertTrue(expected.equals(storeOneGame.publishGame("Kerbal Space Program", "Sandbox")));
            }

            @Test
            public void shouldPublishOldGame() {
                List<Game> expected = new ArrayList<>();
                GameStore storeOneGame = new GameStore();
                expected.add(new Game("Witcher 3", "Action", storeOneGame));
                //assertTrue(expected.equals(storeOneGame.publishGame("Witcher 3", "Action")));
            }
        }

        @Nested
        @DisplayName("Магазин с несколькими играми")
        public class StoreWithSomeGames {
            @Test
            public void shouldPublishNewGame() {
                List<Game> expected = new ArrayList<>();
                GameStore storeSomeGames = new GameStore();
                expected.add(new Game("Witcher 3", "Action", storeSomeGames));
                expected.add(new Game("The Elder Scrolls V: Skyrim", "Action", storeSomeGames));
                expected.add(new Game("Kerbal Space Program", "Sandbox", storeSomeGames));
                expected.add(new Game("Europe Universalis IV", "Strategy", storeSomeGames));
                expected.add(new Game("XCOM 2", "Tactic", storeSomeGames));
                expected.add(new Game("Grand Theft Auto V", "Action", storeSomeGames));
                //assertTrue(expected.equals(storeSomeGames.publishGame("Grand Theft Auto V", "Action")));
            }

            @Test
            public void shouldPublishOldGame() {
                List<Game> expected = new ArrayList<>();
                GameStore storeSomeGames = new GameStore();
                expected.add(new Game("Witcher 3", "Action", storeSomeGames));
                expected.add(new Game("The Elder Scrolls V: Skyrim", "Action", storeSomeGames));
                expected.add(new Game("Kerbal Space Program", "Sandbox", storeSomeGames));
                expected.add(new Game("Europe Universalis IV", "Strategy", storeSomeGames));
                expected.add(new Game("XCOM 2", "Tactic", storeSomeGames));
                assertTrue(expected.equals(storeSomeGames.publishGame("Europe Universalis IV", "Strategy")));
            }
        }
    }

    @Nested
    @DisplayName("Тестирование метода containsGame()")
    public class containsGameTests {
        @Nested
        @DisplayName("Пустой магазин")
        public class EmptyStore {
            @Test
            public void shouldUnContained() {
                GameStore storeEmpty = new GameStore();
                assertFalse(storeEmpty.containsGame(new Game("Witcher 3", "Action", storeEmpty)));
            }
        }

        @Nested
        @DisplayName("Магазин с одной игрой")
        public class StoreWithOneGame {
            @Test
            public void shouldContained() {
                GameStore storeOneGame = new GameStore();
                assertTrue(storeOneGame.containsGame(new Game("Witcher 3", "Action", storeOneGame)));
            }

            @Test
            public void shouldUnContained() {
                GameStore storeOneGame = new GameStore();
                assertFalse(storeOneGame.containsGame(new Game("Kerbal Space Program", "Sandbox", storeOneGame)));
            }
        }

        @Nested
        @DisplayName("Магазин с несколькими играми")
        public class StoreWithSomeGames {
            @Test
            public void shouldContained() {
                GameStore storeSomeGames = new GameStore();
                assertTrue(storeSomeGames.containsGame(new Game("Kerbal Space Program", "Sandbox", storeSomeGames)));
            }

            @Test
            public void shouldUnContained() {
                GameStore storeSomeGames = new GameStore();
                assertFalse(storeSomeGames.containsGame(new Game("Factorio", "Sandbox", storeSomeGames)));
            }
        }
    }
}

