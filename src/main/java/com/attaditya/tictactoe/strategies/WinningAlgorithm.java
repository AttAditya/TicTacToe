package com.attaditya.tictactoe.strategies;

import com.attaditya.tictactoe.models.Board;
import com.attaditya.tictactoe.models.Move;

import java.util.HashMap;
import java.util.Map;

public class WinningAlgorithm {
    Map<Integer, Map<Character, Integer>> rowMaps;
    Map<Integer, Map<Character, Integer>> colMaps;
    Map<Character, Integer> diagLt;
    Map<Character, Integer> diagRt;

    public WinningAlgorithm() {
        rowMaps = new HashMap<>();
        colMaps = new HashMap<>();
        diagLt = new HashMap<>();
        diagRt = new HashMap<>();
    }

    public boolean checkWinner(Board board, Move move) {
        updateMaps(board, move);
        return checkMaps(board, move);
    }

    boolean checkMaps(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        char character = move.getPlayer().getSymbol().getCharacter();

        int size = board.getSize();

        boolean rowCheck = checkRow(row, character, size);
        boolean colCheck = checkColumn(col, character, size);
        boolean diagLtCheck = false;
        boolean diagRtCheck = false;

        if (row - col == 0) {
            diagLtCheck = checkLeftDiagonal(character, size);
        }

        if (row + col == size - 1) {
            diagRtCheck = checkRightDiagonal(character, size);
        }

        return rowCheck || colCheck || diagLtCheck || diagRtCheck;
    }

    boolean checkRow(int row, char character, int size) {
        return rowMaps.get(row).get(character) == size;
    }

    boolean checkColumn(int col, char character, int size) {
        return colMaps.get(col).get(character) == size;
    }

    boolean checkLeftDiagonal(char character, int size) {
        return diagLt.getOrDefault(character, 0) == size;
    }

    boolean checkRightDiagonal(char character, int size) {
        return diagRt.getOrDefault(character, 0) == size;
    }

    void updateMaps(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        char character = move.getPlayer().getSymbol().getCharacter();

        updateRows(row, character);
        updateColumns(col, character);

        if (row - col == 0) {
            updateLeftDiagonal(character);
        }

        if (row + col == board.getSize() - 1) {
            updateRightDiagonal(character);
        }
    }

    void updateRows(int row, char character) {
        if (!rowMaps.containsKey(row)) {
            rowMaps.put(row, new HashMap<>());
        }

        Map<Character, Integer> currentRow = rowMaps.get(row);
        currentRow.put(character, currentRow.getOrDefault(character, 0) + 1);
    }

    void updateColumns(int col, char character) {
        if (!colMaps.containsKey(col)) {
            colMaps.put(col, new HashMap<>());
        }

        Map<Character, Integer> currentCol = colMaps.get(col);
        currentCol.put(character, currentCol.getOrDefault(character, 0) + 1);
    }

    void updateLeftDiagonal(char character) {
        diagLt.put(character, diagLt.getOrDefault(character, 0) + 1);
    }

    void updateRightDiagonal(char character) {
        diagRt.put(character, diagRt.getOrDefault(character, 0) + 1);
    }
}
