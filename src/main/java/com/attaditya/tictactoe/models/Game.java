package com.attaditya.tictactoe.models;

import com.attaditya.tictactoe.enums.CellFillType;
import com.attaditya.tictactoe.enums.GameState;
import com.attaditya.tictactoe.exceptions.InvalidMoveException;
import com.attaditya.tictactoe.strategies.WinningAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final Board board;
    private final List<Player> players;
    private final List<Move> moves;
    private GameState gameState;
    private Integer nextPlayerIndex;
    private Player winner;
    private final WinningAlgorithm winningAlgorithm;

    public Game(int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.RUNNING;
        this.nextPlayerIndex = 0;
        this.winner = null;
        this.winningAlgorithm = new WinningAlgorithm();
    }

    public GameState getGameState() {
        return gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void printBoard() {
        this.board.print();
    }

    private boolean validateMode(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row < 0 || row >= this.board.getSize()) {
            return false;
        }

        if (col < 0 || col >= this.board.getSize()) {
            return false;
        }

        Cell boardCell = board.getBoard().get(row).get(col);
        return boardCell.getCellFillType() == CellFillType.EMPTY;
    }

    public void makeMove() {
        Player currentPlayer = players.get(nextPlayerIndex);

        System.out.println(currentPlayer.getName() + "'s turn");

        Move move = currentPlayer.makeMove(board);

        if (!validateMode(move)) {
            throw new InvalidMoveException("Invalid move made by " + currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell boardCell = board.getBoard().get(row).get(col);
        boardCell.setPlayer(currentPlayer);
        boardCell.setCellFillType(CellFillType.USED);

        Move finalMove = new Move(boardCell, currentPlayer);
        moves.add(finalMove);

        nextPlayerIndex = (nextPlayerIndex + 1) % players.size();
        boolean winning = winningAlgorithm.checkWinner(board, finalMove);

        if (winning) {
            winner = currentPlayer;
            gameState = GameState.ENDED;
        }

        printBoard();
    }
}
