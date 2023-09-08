package com.conplement.gameOfLife;

import com.conplement.io.Io;

public class GameOfLife {

    private final int tickRate;
    // private final int dimensionX;
    // private final int dimensionY;
    private Board currentBoard;
    private int generationCounter = 0;

    public GameOfLife(boolean[][] INITIAL_GENERATION, int tickRate) {   //old constructor
        this.currentBoard = Board.newBoardForBooleanPattern(INITIAL_GENERATION);
        this.tickRate = 1000/ tickRate ;
    }

    public int numberOfGeneration(){
        return generationCounter;
    }


    public void calcNextGeneration(){
        currentBoard = currentBoard.calcNextBoard();
        generationCounter++;
    }

    public int getTickrate () {
        return tickRate;
    }

    public boolean[][] getCurrentGenAsBooleanArray(){
        return currentBoard.getBooleanCellStatusArray();
    }
}
