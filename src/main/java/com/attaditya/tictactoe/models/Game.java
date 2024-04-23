package com.attaditya.tictactoe.models;

import com.attaditya.tictactoe.enums.GameState;

import java.util.List;

public class Game {
    public Board board;
    public Player[] players;
    public Integer turn;
    public Player winner;
    public List<Move> moves;
    public GameState gameState;
}
