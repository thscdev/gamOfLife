package com.conplement.gameOfLife;

public class Board {
    Cell[][] board;

    private Board(int x, int y){
        this.board = new Cell[x][y];
    }
    public static Board newSizedBoard(int x, int y){
        return new Board(x, y);
    }
}
