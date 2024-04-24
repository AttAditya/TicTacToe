package com.attaditya.tictactoe.models;

import com.attaditya.tictactoe.enums.PlayerType;

import java.util.Scanner;

public class Player {
    private final String name;
    private final Symbol symbol;
    private final PlayerType playerType;
    private final Scanner scanner;

    public Player(String name, Symbol symbol, PlayerType playerType, Scanner scanner) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
        this.scanner = scanner;
    }

    public Player(String name, Symbol symbol, Scanner scanner) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = PlayerType.HUMAN;
        this.scanner = scanner;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Move makeMove(Board board) {
        System.out.print("Enter row number: ");
        int row = scanner.nextInt() - 1;

        System.out.print("Enter column number: ");
        int col = scanner.nextInt() - 1;

        return new Move(new Cell(row, col), this);
    }
}
