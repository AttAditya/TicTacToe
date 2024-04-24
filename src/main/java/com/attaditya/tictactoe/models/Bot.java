package com.attaditya.tictactoe.models;

import com.attaditya.tictactoe.enums.BotDifficulty;
import com.attaditya.tictactoe.enums.CellFillType;
import com.attaditya.tictactoe.enums.PlayerType;

import java.util.List;

public class Bot extends Player {
    private BotDifficulty difficulty;

    public Bot(String name, Symbol symbol, BotDifficulty difficulty) {
        super(name, symbol, PlayerType.BOT, null);
        this.difficulty = difficulty;
    }

    public BotDifficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(BotDifficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public Move makeMove(Board board) {
        for (List<Cell> cells : board.getBoard()) {
            for (Cell cell : cells) {
                if (cell.getCellFillType() == CellFillType.EMPTY) {
                    return new Move(cell, this);
                }
            }
        }

        return null;
    }
}
