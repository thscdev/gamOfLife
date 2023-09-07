package com.conplement.io;

import com.conplement.gameOfLife.Generation;

public class Io {

    public void printBooleanArray(boolean[][] board) {
        //boolean[][] board = gen.getGenerationState();

        for(int x = 0; x < board.length; x++) {
            for(int y = 0; y < board.length; y++) {
                System.out.print(board[x][y] == false ? "." : "#");
            }
            System.out.println();
        }
    }
}
