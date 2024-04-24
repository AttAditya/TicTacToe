package com.attaditya.tictactoe.controllers;

import com.attaditya.tictactoe.enums.GameState;
import com.attaditya.tictactoe.models.Game;
import com.attaditya.tictactoe.models.Player;

import java.util.List;

public class GameController {
    private Game game;

    public void startGame(int size, List<Player> players) {
        // TODO: Create exception for players with same symbols
        this.game = new Game(size, players);
    }

    public void printBoard() {
        game.printBoard();
    }

    public void makeMove() {
        game.makeMove();
    }

    public GameState checkState() {
        return game.getGameState();
    }

    public Player getWinner() {
        return game.getWinner();
    }
}
