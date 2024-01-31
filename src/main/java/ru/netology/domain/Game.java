package ru.netology.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

        if (!players.contains(player1)) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован"
            );
        }
        if (!players.contains(player2)) {
            throw new NotRegisteredException(
                    "Игрок " + playerName2 + " не зарегистрирован"
            );
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
