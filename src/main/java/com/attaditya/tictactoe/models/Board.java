package com.attaditya.tictactoe.models;

import com.attaditya.tictactoe.enums.CellFillType;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private final Integer size;
    private final List<List<Cell>> board;

    public Board(Integer size) {
        this.size = size;
        this.board = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            board.add(new ArrayList<>());

            for (int j = 0; j < size; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public Integer getSize() {
        return size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void print() {
        System.out.println();

        System.out.println("        Col Col Col ");
        System.out.println("         1   2   3  ");

        for (int i = 0; i < size; i++) {
            List<Cell> row = board.get(i);

            System.out.println("       +---+---+---+");
            System.out.print(" Row " + (i + 1) + " |");

            for (Cell cell : row) {
                System.out.print(" ");

                if (cell.getCellFillType() == CellFillType.EMPTY) {
                    System.out.print(" ");
                } else {
                    System.out.print(cell.getPlayer().getSymbol().getCharacter());
                }

                System.out.print(" |");
            }

            System.out.println();
        }

        System.out.println("       +---+---+---+");
        System.out.println();
    }
}
