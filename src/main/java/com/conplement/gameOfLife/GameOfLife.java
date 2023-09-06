package com.conplement.gameOfLife;

import com.conplement.io.Io;

public class GameOfLife {

    private final int TICK_RATE;
    private final int DIMENSION_X;
    private final int DIMENSION_Y;
    private Generation currentGeneration;
    private int generationCounter = 0;

    final String ANSI_CLS = "\u001b[2J";
    final String ANSI_HOME = "\u001b[H";

    public GameOfLife(Generation INITIAL_GENERATION, int TICK_RATE) {
        this.currentGeneration = INITIAL_GENERATION;
        this.TICK_RATE = TICK_RATE * 100; // Wa

        this.DIMENSION_X = currentGeneration.getGenerationState().length;
        this.DIMENSION_Y = currentGeneration.getGenerationState()[0].length;
    }

    public void start() throws InterruptedException {
        Io io = new Io();


        while(generationCounter<100) {
            System.out.println("Generation: " + generationCounter);
            io.printGeneration(currentGeneration);
            currentGeneration = currentGeneration.calcNextGeneration();
            generationCounter++;
            Thread.sleep(TICK_RATE);

            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        System.out.println("Das Programm wurde Beendet");
    }


}
