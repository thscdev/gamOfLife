package com.conplement;


import com.conplement.gameOfLife.Generation;
import com.conplement.gameOfLife.GameOfLife;
import com.conplement.io.Io;

public class Application {

    public static void main(String[] args) throws InterruptedException {

        var blinker = new boolean[][]{
                {false, false, false, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, true, false, false},
                {false, false, false, false, false}
        };

        final boolean[][] clock = new boolean[][] {
                {false, false, false, false, false, false},
                {false, false, false, true, false, false},
                {false, true, true, false, false, false},
                {false, false, false, true, true, false},
                {false, false, true, false, false, false},
                {false, false, false, false, false, false}
        };

        final boolean[][] toad = new boolean[][] {
                {false, false, false, false, false, false},
                {false, false, true, true, false, false},
                {false, true, false, false, false, false},
                {false, false, false, false, true, false},
                {false, false, true, true, false, false},
                {false, false, false, false, false, false}
        };

        var io = new Io();




        var gameClock = new GameOfLife(clock, 4);
        var gameBlinker = new GameOfLife(blinker, 4);
        var gameToad = new GameOfLife(toad, 4);

        while (true) {
            System.out.println("Generation Clock: " + gameClock.numberOfGeneration());
            io.printBooleanArray(gameClock.getCurrentGenAsBooleanArray());
            gameClock.calcNextGeneration();

            System.out.println("");

            System.out.println("Generation Blinker: " + gameBlinker.numberOfGeneration());
            io.printBooleanArray(gameBlinker.getCurrentGenAsBooleanArray());
            gameBlinker.calcNextGeneration();

            System.out.println("");

            System.out.println("Generation Toad: " + gameToad.numberOfGeneration());
            io.printBooleanArray(gameToad.getCurrentGenAsBooleanArray());
            gameToad.calcNextGeneration();

            Thread.sleep(gameClock.getTickrate());
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }

        //gameClock.start();

        // , Test für Modul schreiben -> refactorn
    }
}
