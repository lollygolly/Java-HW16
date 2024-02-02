package ru.netology.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    HashMap<Integer, Player> players = new HashMap<>(); // key - getID, value - player

    public void register(Player player) {
        players.put(player.getId(), player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (Integer id : players.keySet()) {
            Player name = players.get(id);
            if (name.getName().equals(playerName1)) {
                player1 = name;
            }
        }
        for (Integer id : players.keySet()) {
            Player name = players.get(id);
            if (name.getName().equals(playerName2)) {
                player2 = name;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован"
            );
        }
        if (player2 == null) {
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
