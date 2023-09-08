package com.conplement.gameOfLife;

import com.conplement.io.Io;

public class GameOfLife {

    private final int tickRate;
    private Board currentBoard;
    private int generationCounter = 0;
    private Renderer renderer;

    public GameOfLife(boolean[][] initialBoard, int tickRate, Renderer renderer) {
        this.currentBoard = Board.newBoardForBooleanPattern(initialBoard);
        this.tickRate = 1000/ tickRate ;
        this.renderer = renderer;
    }

    public void start() throws InterruptedException {
        while(true){
            renderer.render(currentBoard, generationCounter);
            currentBoard= currentBoard.calcNextBoard();
            generationCounter++;
            Thread.sleep(tickRate);
        }
    }
}
