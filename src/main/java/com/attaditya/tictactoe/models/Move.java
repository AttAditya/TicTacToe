package com.attaditya.tictactoe.models;

public class Move {
    private final Cell cell;
    private final Player player;

    public Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

    public Cell getCell() {
        return cell;
    }

    public Player getPlayer() {
        return player;
    }
}
