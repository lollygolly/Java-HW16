package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void shouldWinFirsPlayer () {
        Player player1 = new Player(1, "Dan", 100);
        Player player2 = new Player(2, "Kit", 50);
        Game game1 = new Game();

        game1.register(player1);
        game1.register(player2);

        Assertions.assertEquals(1, game1.round("Dan", "Kit"));
    }

    @Test
    public void shouldWinSecondPlayer () {
        Player player1 = new Player(1, "Anna", 30);
        Player player2 = new Player(2, "Maria", 70);
        Game game2 = new Game();

        game2.register(player1);
        game2.register(player2);

        Assertions.assertEquals(2, game2.round("Anna", "Maria"));
    }

    @Test
    public void shouldWinBothOfPlayers () {
        Player player1 = new Player(1, "Pit", 60);
        Player player2 = new Player(2, "Max", 60);
        Game game3 = new Game();

        game3.register(player1);
        game3.register(player2);

        Assertions.assertEquals(0, game3.round("Pit", "Max"));
    }

    @Test
    public void shouldThrowExceptionWhenFirstPlayerDidntRegistered () {
        Player player1 = new Player(1, "Lily", 30);
        Player player2 = new Player(2, "Michael", 40);
        Game game4 = new Game();

        game4.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
           game4.round("Lily", "Michael");
        });
    }

    @Test
    public void shouldThrowExceptionWhenSecondPlayerDidntRegistered () {
        Player player1 = new Player(1, "Bob", 80);
        Player player2 = new Player(2, "Trevor", 40);
        Game game5 = new Game();

        game5.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game5.round("Bob", "Trevor");
        });
    }

    @Test
    public void shouldThrowExceptionWhenBothPlayersDidntRegistered () {
        Player player1 = new Player(1, "Molly", 80);
        Player player2 = new Player(2, "Harry", 40);
        Game game6 = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game6.round("Molly", "Harry");
        });
    }
}
