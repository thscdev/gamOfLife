package com.conplement.gameoflife;

import com.conplement.gameoflife.generation.OldGeneration;

public class GameOfLife {

    private final int tickRate;
    private OldGeneration currentOldGeneration;
    private int generationCounter = 0;
    private Renderer renderer;
    private boolean isWrapping;

    private int widht;

    private int height;

    /*
    public GameOfLife(Options options, Renderer renderer) {
        this.currentGeneration = options.isWrapping()
                ? Generation.newSizedBoardWithRandomCells(options.width(), options.height())
                : Generation.newBoardForBooleanPattern(options.pattern());
        this.tickRate = 1000 / options.tickRate();
        this.renderer = renderer;
        this.isBoardWrapping = options.isWrapping();
    }

     */

    public GameOfLife(Options options, Renderer render){
        this.isWrapping = options.isWrapping();
        this.widht = options.width();
        this.height = options.height();

        if(isWrapping){
            currentOldGeneration =
        }
    }


    public void start() throws InterruptedException {
        while (true) {
            renderer.render(currentOldGeneration, generationCounter);
            OldGeneration newOldGeneration = currentOldGeneration.calcNextBoard(isBoardWrapping);
            currentOldGeneration = newOldGeneration;
            generationCounter++;
            Thread.sleep(tickRate);
        }
    }
}
