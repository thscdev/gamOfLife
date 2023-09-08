package com.conplement.gameOfLife;

import com.conplement.renderer.ClassicConsoleRender;
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

    @Test
    void givenBlinker_expectBlinkerResult() {

        Board board = Board.newBoardForBooleanPattern(blinker);

        Board nextBoard = board.calcNextBoard();

        assertArrayEquals(blinkerResult, nextBoard.getBooleanCellStatusArray());
    }

    @Test
    void givenClock_expectClockResult() {
        Board board = Board.newBoardForBooleanPattern(clock);

        Board nextBoard = board.calcNextBoard();

        assertArrayEquals(clockResult, nextBoard.getBooleanCellStatusArray());
    }

    @Test
    void givenToad_expectToadResultAfter3Generations() {
        Board board = Board.newBoardForBooleanPattern(toad);

        Board nextBoard = board.calcNextBoard();
        nextBoard = nextBoard.calcNextBoard();
        nextBoard = board.calcNextBoard();

        assertArrayEquals(toadResult, nextBoard.getBooleanCellStatusArray());
    }

}