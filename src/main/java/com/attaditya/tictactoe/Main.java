package com.attaditya.tictactoe;

import com.attaditya.tictactoe.controllers.GameController;
import com.attaditya.tictactoe.enums.GameState;
import com.attaditya.tictactoe.models.Player;
import com.attaditya.tictactoe.models.Symbol;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player player1 = new Player("Player 1", new Symbol('X'), scanner);
        Player player2 = new Player("Player 2", new Symbol('O'), scanner);

        List<Player> players = new ArrayList<>();

        players.add(player1);
        players.add(player2);

        GameController gameController = new GameController();
        gameController.startGame(3, players);
        gameController.printBoard();

        while (gameController.checkState() == GameState.RUNNING) {
            gameController.makeMove();
        }

        if (gameController.checkState() == GameState.ENDED) {
            System.out.println(gameController.getWinner().getName() + " won the game!");
        } else {
            System.out.println("Draw!");
        }
    }
}