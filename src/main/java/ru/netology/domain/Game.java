package ru.netology.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    HashMap<Integer, String> players = new HashMap<>(); // key - getID, value - getName

    public void register(Player player) {
        players.put(player.getId(), player.getName());
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (Integer id : players.keySet()) {
            String name = players.get(player1.getId());
            if (name.equals(playerName1)) {
                player1.getName().equals(name);
            }
        }
        for (Integer id : players.keySet()) {
            String name = players.get(player2.getId());
            if (name.equals(playerName2)) {
                player2.getName().equals(name);
            }
        }

        if (!players.get(player1.getId()).equals(playerName1)) {
            throw new NotRegisteredException(
                    "Игрок " + playerName1 + " не зарегистрирован"
            );
        }
        if (!players.get(player2.getId()).equals(playerName2)) {
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
