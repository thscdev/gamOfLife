package com.conplement.gameOfLife;

import com.conplement.io.Io;

public class GameOfLife {

    private final int tickRate;
    private final int dimensionX;
    private final int dimensionY;
    private Generation currentGeneration;
    private int generationCounter = 0;

    public GameOfLife(boolean[][] INITIAL_GENERATION, int tickRate) {
        this.currentGeneration = new Generation(INITIAL_GENERATION);
        this.tickRate = 1000/ tickRate ;

        this.dimensionX = currentGeneration.getGenerationState().length;
        this.dimensionY = currentGeneration.getGenerationState()[0].length;
    }

    //public static GameOfLife randomGOLDimension(int dimension) {

    //}

    public int numberOfGeneration(){
        return generationCounter;
    }

    public Generation getCurrentGeneration(){
        return currentGeneration;
    }

    public void calcNextGeneration(){
        currentGeneration = currentGeneration.calcNextGeneration();
        generationCounter++;
    }

    public int getTickrate () {
        return tickRate;
    }

    public boolean[][] getCurrentGenAsBooleanArray(){
        return currentGeneration.getGenerationState();
    }
}
