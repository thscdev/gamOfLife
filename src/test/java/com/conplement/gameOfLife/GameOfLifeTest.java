package com.conplement.gameOfLife;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeTest {

    private final boolean[][] blinker = new boolean[][]{
            {false, false, false, false, false},
            {false, false, true, false, false},
            {false, false, true, false, false},
            {false, false, true, false, false},
            {false, false, false, false, false}
    };

    private final boolean[][] blinkerResult = new boolean[][]{
            {false, false, false, false, false},
            {false, false, false, false, false},
            {false, true, true, true, false},
            {false, false, false, false, false},
            {false, false, false, false, false}
    };

    private final boolean[][] clock = new boolean[][] {
            { false, false, true, false},
            { true, true, false, false},
            { false, false, true, true},
            { false, true, false, false},
    };

    private final boolean[][] clockResult = new boolean[][] {
            {false, true, false, false},
            {false, true, false, true},
            {true, false, true, false},
            {false, false, true, false}
    };

    private final boolean[][] toad = new boolean[][] {
            {false, true, true, false},
            {true, false, false, false},
            {false, false, false, true},
            {false, true, true, false}
    };

    private final boolean[][] toadResult = new boolean[][] {
            {false, true, false, false},
            {false, true, true, false},
            {false, true, true, false},
            {false, false, true, false}
    };
    /*
    @Test
    void givenBlinker_expectBlinkerResult() {
        var game = new GameOfLife(blinker, 1);
        game.calcNextGeneration();
        assertArrayEquals(blinkerResult, game.getCurrentGenAsBooleanArray() );
    }

    @Test
    void givenClock_expectClockResult() {
        var game = new GameOfLife(clock, 1);
        game.calcNextGeneration();
        assertArrayEquals(clockResult, game.getCurrentGenAsBooleanArray() );
    }

    @Test
    void givenToad_expectToadResult() {
        var game = new GameOfLife(toad, 1);
        game.calcNextGeneration();
        assertArrayEquals(toadResult, game.getCurrentGenAsBooleanArray() );
    }

     */
}