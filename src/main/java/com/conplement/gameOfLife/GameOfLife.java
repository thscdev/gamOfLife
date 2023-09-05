package com.conplement.gameOfLife;

public class GameOfLife {

    private final int TICK_RATE;
    private Generation current;

    public GameOfLife(Generation INITIAL_GENERATION, int TICK_RATE) {
        this.current = INITIAL_GENERATION;
        this.TICK_RATE = TICK_RATE;
    }

    public Generation calcNewGeneration() {
        boolean[][] result;
        boolean[][] currentGenerationState = this.current.getGenerationState();
        int dimension = this.current.getDimension();

        for (int x = 0; x < currentGenerationState.length; x++) {
            // TO DO
        }


        this.current = result;
        return null;
    }

    public boolean cellDeadOrAlife() {
        return false;
    }
}
