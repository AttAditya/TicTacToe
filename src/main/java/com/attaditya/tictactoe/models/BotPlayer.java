package com.attaditya.tictactoe.models;

import com.attaditya.tictactoe.enums.BotDifficulty;
import com.attaditya.tictactoe.enums.PlayerType;

public class BotPlayer implements Player {
    public String name;
    public Symbol symbol;
    public PlayerType playerType;
    public BotDifficulty difficulty;
}
