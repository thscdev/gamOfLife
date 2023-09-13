package com.conplement.gameOfLife;

public interface InputReader {
    boolean[][] getBooleanPattern();

    boolean wantRandomFilledBoard();

    boolean isBoardWrapping();

    int getTickRate();

    int widthForRandomBoard();

    int heightForRandomBoard();

}
