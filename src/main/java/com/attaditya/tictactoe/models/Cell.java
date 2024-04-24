package com.attaditya.tictactoe.models;

import com.attaditya.tictactoe.enums.CellFillType;

public class Cell {
    private Player player;
    private final Integer row;
    private final Integer col;
    private CellFillType cellFillType;

    public Cell(Integer row, Integer col) {
        this.row = row;
        this.col = col;
        this.cellFillType = CellFillType.EMPTY;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Integer getRow() {
        return row;
    }

    public Integer getCol() {
        return col;
    }

    public CellFillType getCellFillType() {
        return cellFillType;
    }

    public void setCellFillType(CellFillType cellFillType) {
        this.cellFillType = cellFillType;
    }
}
