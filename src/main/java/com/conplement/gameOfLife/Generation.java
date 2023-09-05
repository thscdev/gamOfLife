package com.conplement.gameOfLife;

public class Generation {
    private final int DIMENSION;
    private final boolean[][] GENERATION_STATE;

    public Generation (int DIMENSION, boolean[][] GENERATION_STATE) {
        this.DIMENSION = DIMENSION;
        this.GENERATION_STATE = GENERATION_STATE;
    }

    public boolean[][] getGenerationState() {
        return this.GENERATION_STATE;
    }

    public int getDimension(){
        return this.DIMENSION;
    }

}
